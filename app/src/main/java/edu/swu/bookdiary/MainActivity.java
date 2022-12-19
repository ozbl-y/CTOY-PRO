package edu.swu.bookdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ClickDate.myDBHelper myHelper;
    CalendarView calendarView;
    EditText titleResult, memoResult;
    Button btnInsert;
    TextView case1, case2, my;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        titleResult = (EditText) findViewById(R.id.titleResult); // 결과출력
        memoResult = (EditText) findViewById(R.id.memoResult); // 결과출력

        my = findViewById(R.id.my);
        case1 = findViewById(R.id.case1);
        case2 = findViewById(R.id.case2);
        myHelper = new ClickDate.myDBHelper(this);

        final CharSequence[] date = {null};

        btnInsert.setOnClickListener(v -> {
            Intent intent = new Intent(this, ClickDate.class);
            startActivity(intent);
        });

        //리스트형 버튼 클릭시, ListType 페이지로 이동
        case2.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListType.class);
            startActivity(intent);
        });

        // my 버튼 클릭 시 my화면으로 이동
        my.setOnClickListener(v -> {
            Intent intent = new Intent(this, My.class);
            startActivity(intent);
        });

        //날짜 선택 시, click_date화면으로 넘어감
        calendarView.setOnClickListener(v ->{
            Intent intent = new Intent(this, ClickDate.class);
            startActivity(intent);
        });

        case1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '" + titleResult.getText().toString() + "' , "
                        + memoResult.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "저장됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
