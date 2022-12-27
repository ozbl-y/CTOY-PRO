package edu.swu.bookdiary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    // Person Table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DEMO_SQLITE(bookname TEXT, point TEXT, memo TEXT)");
    }


    // Person Table Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS Person");
        //onCreate(db);
    }

    // Person Table 데이터 입력
    public void insert(String bookname, String point, String memo) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO DEMO_SQLITE VALUES('" + bookname + "', " + point + ", '" + memo + "');");
        db.close();
    }

    // Person Table 데이터 수정
    public void update(String bookname, String point, String memo) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 memo 수정
        if (bookname != "") {
            db.execSQL("UPDATE DEMO_SQLITE SET point = " + point + ", memo = '" + memo + "'" + " WHERE bookname = '" + bookname + "';");
        }
        db.close();
    }

    // Person Table 데이터 삭제
    public void delete(String bookname) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        if (bookname != "") {
            db.execSQL("DELETE FROM DEMO_SQLITE WHERE bookname='" + bookname + "';");
        }
        db.close();
    }

    // Person Table 조회
    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM DEMO_SQLITE ", null);
        while (cursor.moveToNext()) {
            result += " TITLE : " + cursor.getString(0)
                    + "| POINT : "
                    + cursor.getInt(1)
                    + "| MEMO : "
                    + cursor.getString(2)
                    + "\n";
        }

        return result;
    }
    /*
    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성 : 제목, 포인트, 메모
        db.execSQL( "CREATE TABLE DEMO_SQLITE ( title TEXT, point INT, memo TEXT, create_at TEXT );");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DEMO_SQLITE");
        onCreate(db);
    }

    public void insert(String create_at, String bookname, String point ) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL( "INSERT INTO DEMO_SQLITE VALUES(null, " + "'" + bookname + "', " + point + ", '"  +  create_at + "');");
        db.close();
    }

    public void update(String bookname, String point) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행의 memo 수정
        if (bookname != "") {
            db.execSQL("UPDATE DEMO_SQLITE SET memo =" + point + " WHERE bookname='" + bookname + "';");
        }
        db.close();
    }

    public void delete(String bookname) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        if (bookname != "") {
            db.execSQL("DELETE FROM DEMO_SQLITE WHERE bookname='" + bookname + "';");
        }
        db.close();
    }

    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM DEMO_SQLITE", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " title : "
                    + cursor.getString(1)
                    + " \n memo :  "
                    + cursor.getString(2)
                    + " \n "
                    + cursor.getString(3)
                    + "\n";

        }

        return result;
    }*/
}
