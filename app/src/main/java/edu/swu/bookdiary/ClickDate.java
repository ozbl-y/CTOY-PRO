package edu.swu.bookdiary;

import android.content.Context;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
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

public class ClickDate extends AppCompatActivity {
    //date누르면 화면하단에 책제목, 평점
    private RatingBar ratingbar;

    TextView back, my;
    EditText bookname, addmemo;
    Button save, change;
    String name, memo; // filename

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

        //save 클릭하면 메모 저장됨 - 수정해야됨
        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream outFs = openFileOutput(memo, Context.MODE_PRIVATE);
                String mm = 
            }
        });*/
        /*        btnWrite.setOnClickListener(new View.OnClickListener(){
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

/*        save.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                try {
                    FileOutputStream outFs = openFileOutput(name, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), name +
                            " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });*/

/*        ratingbar.setOnRatingBarChangeListener(new Listener());*/


/*        String book = readBookName(bk);
        String memo = readMemo(mm);
        bookname.setText(book);
        addmemo.setText(memo);

        save.setEnabled(true);
        change.setEnabled(true);*/

        /*save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput(bk, Context.MODE_PRIVATE);
                    FileOutputStream outFs2 = openFileOutput(mm, Context.MODE_PRIVATE);
                    String book = bookname.getText().toString();
                    String memo = addmemo.getText().toString();
                    outFs.write(book.getBytes());
                    outFs2.write(memo.getBytes());
                    outFs.close();
                    outFs2.close();
                    Toast.makeText(getApplicationContext(), bk + mm +
                            " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });*/
    }

/*    class Listener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingbar.setRating(rating);
        }
    }*/

/*    String readBookName(String fName) {
        String bookStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            bookStr = (new String(txt)).trim();
            //change.setText("수정하기");
        } catch (IOException e) { // 이걸 쓰지 않으면 앱이 그냥 죽어버림
            bookname.setHint(" NONE ");
            //addmemo.setHint(" ");
            //save.setText("새로 저장");
        }
        return bookStr;
    }

    String readMemo(String fName) {
        String memoStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            memoStr = (new String(txt)).trim();
           // change.setText("수정하기");
        } catch (IOException e) {
            addmemo.setHint(" NONE ");
            //addmemo.setHint(" ");
            //save.setText("새로 저장");
        }
        return memoStr;
    }*/

    /*        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date[0] = year + "/" + (month +1) + "/" + dayOfMonth;
               // dateRecord.setText(date[0]);
            }
        });*/
      /*  Intent intent = getIntent();
        final String date = intent.getExtras().getString("ClickDate");
        day.setText(date);*/

}


