package edu.swu.bookdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import io.realm.Realm;

/*저장한 데이터를 보는 class*/
public class ListType extends AppCompatActivity{
    TextView my, case1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_type);

        my = findViewById(R.id.my);
        case1 = findViewById(R.id.case1);

        //결과 찍기 위한 textview
        TextView bookname = findViewById(R.id.bookname); //add
        TextView addmemo = findViewById(R.id.addmemo); //add

        // intent로부터 넘긴 데이터 뽑아냄
        Intent intent= getIntent();
        String title = intent.getStringExtra("title");

        Realm mRealm = Realm.getDefaultInstance();
        MemoV0 vo = mRealm.where(MemoV0.class).equalTo("title", title).findFirst();
        bookname.setText(vo.title);
        addmemo.setText(vo.content);


/*        //리스트형 버튼 클릭시, Main 페이지로 이동
        case1.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        // my 버튼 클릭 시 my화면으로 이동
        my.setOnClickListener(v -> {
            Intent intent = new Intent(this, My.class);
            startActivity(intent);
        });*/

    }
}
