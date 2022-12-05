package edu.swu.bookdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;

    EditText edtDiary;
    TextView case2, my, button;
    String date, fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
      //  edtDiary = (EditText) findViewById(R.id.edtDiary);
        my = findViewById(R.id.my);
        case2 = findViewById(R.id.case2);
        button = findViewById(R.id.button);

        final CharSequence[] date = {null};

        //리스트형 버튼 클릭시, ListType 페이지로 이동
        case2.setOnClickListener(v -> {
            Intent intent = new Intent(this, MemoAdapter.class);
                                          // MemoAdapter -> ListType으로 바꾸기
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
        //date클릭시 ClickDate 페이지로 이동
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, ClickDate.class);
            startActivity(intent);
        });
/*        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClickDate.class);
                intent.putExtra("ClickDate", date[0]);
                startActivity(intent);
            }
        });*/
    }

}