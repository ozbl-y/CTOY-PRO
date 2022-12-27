package edu.swu.bookdiary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    int version = 1;
    DatabaseOpenHelper helper;
    SQLiteDatabase database;
    TextView btnJoin, btnLogin;
    EditText editID, editPW;
    String sql;
    Cursor cursor;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin); // 로그인 버튼
        btnJoin = findViewById(R.id.btnJoin); //회원가입 버튼

        //에디트텍스트
        editID=findViewById(R.id.editID);
        editPW=findViewById(R.id.editPW);

        helper = new DatabaseOpenHelper(Login.this, DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String id = editID.getText().toString();
                String pw = editPW.getText().toString();

                if(id.length() == 0 || pw.length() == 0) {
                    //아이디, 비밀번호 필수 입력
                    Toast toast = Toast.makeText(Login.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT id FROM "+ helper.tableName + " WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount() != 1){
                    //아이디틀림
                    Toast toast = Toast.makeText(Login.this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT pw FROM "+ helper.tableName + " WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                cursor.moveToNext();
                if(!pw.equals(cursor.getString(0))){
                    //비밀번호 틀림
                    Toast toast = Toast.makeText(Login.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    //로그인성공
                    Toast toast = Toast.makeText(Login.this, "로그인성공", Toast.LENGTH_SHORT);
                    toast.show();
                    //인텐트 생성 및 호출
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class); //메인화면으로
                    startActivity(intent);
                    finish();
                    //intent.putExtra("id", id); //id값 보내줌
                }
                cursor.close();
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //회원가입 버튼 클릭
                Toast toast = Toast.makeText(Login.this, "회원가입 화면으로 이동", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
                //finish();
            }
        });

    }

}

