package edu.swu.bookdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    TextView sign, login;
    EditText editID, editPW;
    String ID, PW;
    TextView text1;

/*    final static private String URL = "http://skatpgnsx.dothome.co,kr/Register.php";
    private Map<String, String> map;

    public Login(String userID, String userPW, String NickName){super(Method.POST, null);

        map = new HashMap<>();
        map.put("ID", userID);
        map.put("PW", userPW);
        map.put("NickName", NickName);
    }
    @Override
    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }*/

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.loginbutton); // 로그인 버튼
        sign = findViewById(R.id.signin); //회원가입 버튼

        //에디트텍스트
        editID=findViewById(R.id.editID);
        editPW=findViewById(R.id.editPW);

        //로그인 버튼 클릭 시, 메인페이지로 이동
        login.setOnClickListener(v -> {
            ID = editID.getText().toString();
            PW = editPW.getText().toString();

            if (ID.equals("20518054") && PW.equals("1234")){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else  if (ID.equals("") || PW.equals(""))
                Toast.makeText(getApplicationContext(), "ID와 PW를 다 입력하세요.",
                        Toast.LENGTH_SHORT).show();

            else Toast.makeText(getApplicationContext(), "ID와 PW를 확인하세요",
                        Toast.LENGTH_SHORT).show();


        });

        //회원가입 버튼 클릭시, 회원가입 페이지로 이동
        sign.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignUp.class);
           // startActivity(intent);
        });
    }

}

