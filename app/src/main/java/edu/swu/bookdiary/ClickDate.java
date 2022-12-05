package edu.swu.bookdiary;

import android.content.Context;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ClickDate extends AppCompatActivity {
    //date누르면 화면하단에 책제목, 평점
    private RatingBar ratingbar;
    private MemoAdapter memoAdapter;
    public List<ClickDate> mlist = new ArrayList<>();
//    ArrayList<ListType> mylist = new ArrayList<ListType>();

    TextView back, my;
    EditText bookname, addmemo;
    Button save, change;
    String titles, contents; // filename


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_date);

        my = findViewById(R.id.my);
        back = findViewById(R.id.back);
        bookname = (EditText) findViewById(R.id.bookname);
        ratingbar = findViewById(R.id.point);
        addmemo = (EditText) findViewById(R.id.addmemo);
        save = (Button) findViewById(R.id.save);
        change = (Button) findViewById(R.id.change);

        back.setOnClickListener(v -> onBackPressed() );
        my.setOnClickListener(v -> {
            Intent intent = new Intent(this, My.class);
            startActivity(intent);
        });

        //save 클릭하면 메모 저장됨 - 수정해야됨 -> 일단 ok
        save.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "SUCCESS SAVE", Toast.LENGTH_SHORT).show();
            titles = bookname.getText().toString();
            contents = addmemo.getText().toString();
            Intent add = new Intent(ClickDate.this, MemoAdapter.class);
                                              // 나중에 MemoAdapter -> ListType으로 바꾸기
            add.putExtra("NAME", titles);
            // ratingbar는??????????
            add.putExtra("MEMO", contents);
            setResult(RESULT_OK, add);
            finish();

/*                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("user", mylist.get(position));
                startActivity(intent);*/


        });

    }
}


