package edu.swu.bookdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    TextView back;
    private EditText name,id,pw;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed() );

        //기입 항목
        name = findViewById(R.id.signName);
        id=findViewById(R.id.signID);
        pw=findViewById(R.id.signPW);


        //회원가입 완료 버튼
        submit = findViewById(R.id.signupbutton);
        submit.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });
/*        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = id.getText().toString();
                String userPW = pw.getText().toString();
                String userNickName = name.getText().toString();

                // 회원가입 요청에 대한 응답

                Response.Listener<String> reponseListener =
            }
        });*/

    }
}
