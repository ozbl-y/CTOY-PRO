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

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView my, nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(),
                "DEMO_SQLITE.db", null, 1);

        // 테이블에 있는 모든 데이터 출력
        final TextView result = (TextView) findViewById(R.id.result); // 결과
        final EditText etDate = (EditText) findViewById(R.id.date); // 입력
        final EditText etTitle = (EditText) findViewById(R.id.bookname); // 입력
        final EditText etPoint = (EditText) findViewById(R.id.point); // 입력
        final EditText etMemo = (EditText) findViewById(R.id.memo); // 입력

        Button select = (Button) findViewById(R.id.select);

        my = findViewById(R.id.my);
        nickname = findViewById(R.id.my2);

        my.setOnClickListener(v -> {
            //Intent intent = getIntent(); // login에서 id값 받아옴
            //String userID = intent.getStringExtra("id");
            //nickname.setText(userID);
            Intent intent = new Intent(this, My.class);
            //my.putExtra("id", id); //id값 보내줌
            startActivity(intent);
        });

        long now = System.currentTimeMillis();  // 날짜는 현재 날짜로 고정
        Date date = new Date(now); // 현재 시간 구하기
        // 출력될 포맷 설정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        etDate.setText(simpleDateFormat.format(date));


        // 데이터 추가
        Button insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  bookname = etTitle.getText().toString();
                String  point = etPoint.getText().toString();
                String  memo = etMemo.getText().toString();

                //입력값 누락된거 없는지 확인
                if(bookname.length() == 0 || point.length() == 0 || memo.length() == 0 ) {
                    Toast.makeText( getApplicationContext(), "모든 데이터를 입력하세요.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    //DB 삽입 -> 결과 출력 -> 입력필드 초기화
                    dbHelper.insert(bookname, point, memo);
                    result.setText(dbHelper.getResult());
                    Toast.makeText(getApplicationContext(), "데이터 생성",
                            Toast.LENGTH_SHORT).show();

                    etTitle.setText(null);
                    etPoint.setText(null);
                    etMemo.setText(null);
                }
            }
        });

        // 데이터 수정
        Button update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookname = etTitle.getText().toString();
                String point = etPoint.getText().toString();
                String memo = etMemo.getText().toString();
                dbHelper.update(bookname, point, memo);
                result.setText(dbHelper.getResult());
                Toast.makeText(getApplicationContext(), "데이터 수정",
                        Toast.LENGTH_SHORT).show();
                select.callOnClick();
            }
        });

        // 데이터 삭제
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookname = etTitle.getText().toString();
                dbHelper.delete(bookname);
                result.setText(dbHelper.getResult());
                Toast.makeText(getApplicationContext(), "데이터 삭제",
                        Toast.LENGTH_SHORT).show();
                select.callOnClick();
            }
        });

        // 데이터 조회
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbHelper.getResult());
                Toast.makeText(getApplicationContext(), "데이터 조회",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

}
