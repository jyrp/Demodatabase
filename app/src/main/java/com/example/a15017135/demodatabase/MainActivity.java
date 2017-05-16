package com.example.a15017135.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button btnInsert,btnGetTasks;
    TextView tvResult;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<task> Task;
     Integer tvID;
    String tvDesc;
    String tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (TextView)  findViewById(R.id.tvResults);
        lv = (ListView)this.findViewById(R.id.lvTask);

        Task = new ArrayList<task>();
        for (int a = 0; a < Task.size(); a++) {
           tvID = Task.get(a).getId();
            tvDesc = Task.get(a).getDescription();
            tvDate = Task.get(a).getDate();
            Task.add(new task(tvID, tvDesc, tvDate));
        aa = new taskAdapter(this, R.layout.row, Task);
        lv.setAdapter(aa);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                db.close();

                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    Task.add(new task(i,data.get(i),data.get(i)));

                }
                aa.notifyDataSetChanged();
            }

    });
}}}
