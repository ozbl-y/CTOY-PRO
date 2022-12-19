package edu.swu.bookdiary;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;


/*저장한 데이터를 보는 class*/
public class ListType extends AppCompatActivity{
   // private final String dbName = "webnautes";
   // private final String tableName = "books";

    ClickDate.myDBHelper myHelper;
    TextView my, case1, case2;
    EditText titleResult, memoResult;
    SQLiteDatabase sqlDB; // db를 다루기위한 데이터베이스 객체 생성
    ListView list; // ListView 객체 생성
    ListAdapter adapter;
    String dbName = "myDB";
    String tableName = "customer";
    Cursor cursor;
    String[] result; // ArrayAdapter에 넣을 배열 생성
    String sql;


    ArrayList<HashMap<String, String>> bookList;
    private static final String TAG_TITLE = "title";
    private static final String TAG_MEMO = "memo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_type);

       // list = (ListView) findViewById(R.id.listview);
        my = findViewById(R.id.my);
        case1 = findViewById(R.id.case1);
        case2 = findViewById(R.id.case2);

        titleResult = (EditText) findViewById(R.id.titleResult);
        memoResult = (EditText) findViewById(R.id.memoResult);

        //리스트형 버튼 클릭시, Main 페이지로 이동
        case1.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        // my 버튼 클릭 시 my화면으로 이동
        my.setOnClickListener(v -> {
            Intent intent = new Intent(this, My.class);
            startActivity(intent);
        });

        myHelper = new ClickDate.myDBHelper(this);
        //showList();

        sqlDB = openOrCreateDatabase(dbName, MODE_PRIVATE, null); //있으면 열고 없으면 DB생성

        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                String strtitle = "BOOK NAME" + "\r\n";
                String strmemo = "MEMO" + "\r\n";

                while (cursor.moveToNext()) { // moveToNext : 커서 변수의 다음행으로 넘어감
                    strtitle += cursor.getString(0) + "\r\n";
                    strmemo += cursor.getString(1) + "\r\n";
                }

                //누적한 문자열을 에디트텍스트에 출력
                titleResult.setText(strtitle);
                memoResult.setText(strmemo);

                cursor.close();
                sqlDB.close();

                /*try{
                    sqlDB = myHelper.getReadableDatabase();
                    sql = "select * from " + tableName;
                    cursor = sqlDB.rawQuery(sql, null); // 모든 테이블 조회 후 커서에 대입

                    int count = cursor.getCount(); // db에 저장된 행 개수를 읽어옴
                    result = new String[count]; // 저장된 행 개수만큼의 배열 생성


                    for (int i=0; i<count; i++){
                        cursor.moveToNext(); // 첫 번째에서 다음 레코드가 없을 때까지 읽음
                        String strtitle = cursor.getString(0) + "\r\n";
                        String strmemo = cursor.getString(1) + "\r\n";
                        result[i] = strtitle + " " + strmemo;
                    }
                    System.out.println("ok");

                    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.activity_list_item, result);
                    list.setAdapter(adapter);

                    cursor.close();
                    sqlDB.close();

                }catch (Exception e){
                    System.out.println("Error : "+ e);
                }*/
            }
        });
    }

    /*protected void showList(){
        try{
            SQLiteDatabase ReadDB = this.openOrCreateDatabase(dbName, MODE_PRIVATE, null);

            //select문을 사용해 테이블에 있는 데이터 가져옴
            Cursor c = ReadDB.rawQuery("SELECT * FROM " + tableName, null);
            if(c != null){
                if(c.moveToFirst()){
                    do{
                        //테이블에서 두 개의 컬럼값을 가져와서
                        String TITLE = c.getString(0);
                        String MEMO = c.getString(1);

                        //hashmap에 넣어줌
                        HashMap<String , String > books = new HashMap<String, String>();

                        books.put(TAG_TITLE, TITLE);
                        books.put(TAG_MEMO, MEMO);

                        //arraylist에 추가
                        bookList.add(books);
                    }while (c.moveToNext());
                }
            }

            ReadDB.close();
            //새로운 adapter 생성해서 데이터 넣어주고
            adapter = new SimpleAdapter(
                    this, bookList, R.layout.list_item, new String[]{TAG_TITLE, TAG_MEMO},
                    new int[]{R.id.name, R.id.phone}
            );
            // 와면에 보여주기 위해 listview에 연결
            list.setAdapter(adapter);
        }catch (SQLiteException se){
            Toast.makeText(getApplicationContext(), se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("", se.getMessage());
        }
    }*/
}
