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
    EditText edtname, edtpoint, edtmemo;
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

        save.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str1 = edtname.getText().toString();
                    String str2 = edtpoint.getText().toString();
                    String str3 = edtmemo.getText().toString();
                    outFs.write(str1.getBytes());
                    outFs.write(str2.getBytes());
                    outFs.write(str3.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName +
                            " 이 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

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

