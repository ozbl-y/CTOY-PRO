package edu.swu.bookdiary;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.Menu;
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
import java.util.ArrayList;
import java.util.List;

/*ADD쪽*/

public class ClickDate extends AppCompatActivity {
    //date누르면 화면하단에 책제목, 평점

    private RatingBar ratingbar;

    myDBHelper myHelper;
    TextView back, my, case1, case2;
    EditText bookname, addmemo; // user입력view (bookname = titleView, addmemo = contentView)
    Button btnInsert, btnUpdate,btnDelete; //save = addBtn
    String dbname = "myDB";
    String tablename = "customer";
    String sql;
    SQLiteDatabase sqlDB; // db를 다루기위한 데이터베이스 객체 생성



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_date);

        my = findViewById(R.id.my);
        back = findViewById(R.id.back);

        bookname = (EditText) findViewById(R.id.bookname);
        addmemo = (EditText) findViewById(R.id.addmemo);
        ratingbar = findViewById(R.id.point);

        btnInsert = (Button) findViewById(R.id.btnInsert); // 입력
        btnDelete = (Button) findViewById(R.id.btnDelete); // 삭제
        btnUpdate = (Button) findViewById(R.id.btnUpdate); // 수정

        back.setOnClickListener(v -> onBackPressed() );
        my.setOnClickListener(v -> {
            Intent intent = new Intent(this, My.class);
            startActivity(intent);
        });


        myHelper = new myDBHelper(this);

        /*save 클릭하면 에디트텍스트의 값이 입력되는 리스터 코딩*/
        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '" + bookname.getText().toString() + "' , "
                        + addmemo.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "저장됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (bookname.getText().toString() != "") {
                    sqlDB.execSQL("UPDATE groupTBL SET gNumber ="
                            + addmemo.getText() + " WHERE gName = '"
                            + bookname.getText().toString() + "';");
                }
                sqlDB.close();

                Toast.makeText(getApplicationContext(), "수정됨",
                        Toast.LENGTH_SHORT).show();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (bookname.getText().toString() != "") {
                    sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"
                            + addmemo.getText().toString() + "';");

                }
                sqlDB.close();

                Toast.makeText(getApplicationContext(), "삭제됨",
                        Toast.LENGTH_SHORT).show();
                //btnSelect.callOnClick();
            }
        });

    }


    public static class myDBHelper extends SQLiteOpenHelper {
        /*생성자 정의*/
        public myDBHelper(Context context) {
            // groupDB : 새로 생성될 데이터베이스의 파일명
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            /*onUpgrade()에서 호출되거나 데이터 입력할 때 혹은 테이블 없을 때 1회 호출*/
            db.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*테이블 삭제하고 새로 생성, 초기화할 때 호출 */
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }
}


