package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDetails extends AppCompatActivity {
    EditText myTask,myDescription;
    Button addDetails;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);
        myTask=findViewById(R.id.myTask);
        myDescription=findViewById(R.id.myDescription);
        addDetails=findViewById(R.id.addDetails);
        database=new Database(this);
        addDetails.setOnClickListener(v->{
            String first=myTask.getText().toString();
            String second=myDescription.getText().toString();

            if(!first.isEmpty() && !second.isEmpty()) {
                database.addValue(first, second);
                Toast.makeText(this,"Data Added Successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddDetails.this,MainActivity.class));
            }else{
                Toast.makeText(this,"Please Enter Details",Toast.LENGTH_SHORT).show();
            }
        });
    }
}