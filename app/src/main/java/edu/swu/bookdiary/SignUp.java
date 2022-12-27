package edu.swu.bookdiary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity { // extends Info
    int version = 1;
    DatabaseOpenHelper helper;
    SQLiteDatabase database;
    TextView back;
    EditText editID, editPW;
    Button btnJoin;
    String sql;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );

        //기입 항목
        editID=findViewById(R.id.editID);
        editPW=findViewById(R.id.editPW);

        //회원가입 완료 버튼
        btnJoin = findViewById(R.id.btnJoin);
        helper = new DatabaseOpenHelper(SignUp.this, DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

        btnJoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String id = editID.getText().toString();
                String pw = editPW.getText().toString();

                if(id.length() == 0 || pw.length() == 0) {
                    //아이디와 비밀번호는 필수 입력사항입니다.
                    Toast toast = Toast.makeText(SignUp.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                sql = "SELECT id FROM "+ helper.tableName + " WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount() != 0){
                    //존재하는 아이디입니다.
                    Toast toast = Toast.makeText(SignUp.this, "존재하는 아이디입니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    helper.insertUser(database,id,pw);
                    Toast toast = Toast.makeText(SignUp.this, " 가입이 완료되었습니다. 로그인을 해주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
