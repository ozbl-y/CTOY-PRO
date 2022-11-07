package edu.swu.bookdiary;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClickDate extends AppCompatActivity {
    EditText bookName, point, addMemo;
    Button my, save;
    TextView back;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_date);

        //뒤로가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );

        bookName = (EditText) findViewById(R.id.bookname);
        point = (EditText) findViewById(R.id.point);
        addMemo = (EditText) findViewById(R.id.addmemo);
        my = (Button) findViewById(R.id.my);
        back = (Button) findViewById(R.id.back);
        save = (Button) findViewById(R.id.save);

        String str = readMemo(fileName);

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
            save.setText("CHANGE");
        } catch (IOException e) { // 이걸 쓰지 않으면 앱이 그냥 죽어버림
            addMemo.setHint("ADD MEMO");
            save.setText("SAVE");
        }
        return memoStr;
    }

}

