package edu.swu.bookdiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder> {

    public Activity activity;
    private List<ClickDate> memoList;
    private Realm realm;
    public MemoAdapter(Activity activity, List<ClickDate> memolist) {
        this.activity = activity;
        this.memoList = memolist;
    }

    @NonNull
    @Override
    public MemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_type, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return memoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtitle, mcontent;
        public ViewHolder(final View itemView) {
            super(itemView);
            mtitle = itemView.findViewById(R.id.bookname);
            mcontent = itemView.findViewById(R.id.addmemo);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull MemoAdapter.ViewHolder holder, int position) {
        ClickDate data = memoList.get(position);
        holder.mtitle.setText(data.getTitle());
       // holder.mcontent.setText(data.getContent());
    }

/*
            Toast.makeText(getApplicationContext(), "Save Memo", Toast.LENGTH_SHORT).show();
            titles = title.getText().toString();
            dates = tvDate.getText().toString();
            contents = content.getText().toString();
            Intent add = new Intent(MemoActivity.this, MainActivity.class);
            add.putExtra("title",titles);
            add.putExtra("date",dates);
            add.putExtra("content",contents);
            setResult(RESULT_OK,add);
            finish();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtitle, mdate, mcontent;
        public ViewHolder(final View itemView) {
            super(itemView);
            mtitle = itemView.findViewById(R.id.mtitle);
            mdate = itemView.findViewById(R.id.mdate);
            mcontent = itemView.findViewById(R.id.mcontent);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull MemoAdapter.ViewHolder holder, int position) {
        Memo data = memoList.get(position);
        holder.mtitle.setText(data.getTitle());
        holder.mdate.setText(data.getDate());
        holder.mcontent.setText(data.getContent());

    }*/
}
/*public class ListType extends AppCompatActivity {
    TextView my, case1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_type);

        my = findViewById(R.id.my);
        case1 = findViewById(R.id.case1);


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

        final String[] mid = {"히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
                "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이"};

        ListView list = (ListView) findViewById(R.id.listView1);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mid);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(getApplicationContext(), mid[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}*/

