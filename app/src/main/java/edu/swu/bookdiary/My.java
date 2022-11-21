package edu.swu.bookdiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class My extends AppCompatActivity {
    TextView back, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );
        logout = findViewById(R.id.logout);

        // Nickname 부분은 회원가입 할 때 작성한 닉네임으로 보이도록

        // logout누르면 로그인 화면으로
        // my 버튼 클릭 시 my화면으로 이동
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });
    }
    
}
