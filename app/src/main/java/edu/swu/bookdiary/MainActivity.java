package edu.swu.bookdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    DatePicker dp;
    EditText edtDiary;
    Button my, case1, case2;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);

      //  edtDiary = (EditText) findViewById(R.id.edtDiary);
        my = (Button) findViewById(R.id.my);
        case1 = (Button) findViewById(R.id.case1);
        case2 = (Button) findViewById(R.id.case2);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        //날짜 선택 시, click_date화면으로 넘어감
/*        calendarView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ClickDate.class);
                startActivityForResult(intent, 0);
            }
        });*/
/*        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(getApplicationContext(), ClickDate.class);
                startActivityForResult(intent, 0);
               // intent.putExtra("activity", "MainActivity");
            }
        });*/
        calendarView.setOnClickListener(v -> {
            Intent intent = new Intent(this, ClickDate.class);
            startActivity(intent);
        });

        //리스트형 버튼 클릭시, ListType 페이지로 이동
        /*case2.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListType.class);
            startActivity(intent);
        });*/
        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListType.class);
                startActivityForResult(intent, 0);
            }
        });

/*        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int datOfMonth) {
                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) +
                        "_" + Integer.toString(datOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });*/

     /*   btnWrite.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName +
                            " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });*/
    }

}