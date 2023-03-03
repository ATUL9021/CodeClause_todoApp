package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> list;
    MyAdapter Adapter;
    FloatingActionButton button;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rc);
        list=new ArrayList<>();
        database=new Database(this);
        list=database.readValues();
        if(list.size()==0){
            startActivity(new Intent(MainActivity.this,AddDetails.class));
        }

        Adapter=new MyAdapter(this,list);
        recyclerView.setAdapter(Adapter);
        Adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        button=findViewById(R.id.button);
        button.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,AddDetails.class));
        });
    }
}