package com.example.todo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    private static String databaseName="todo";
    private static int databaseVersion=1;
    public Database(Context context){
        super(context,databaseName,null,databaseVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String query="create table atul( task text , description text);";
            sqLiteDatabase.execSQL(query);
    }

    public void addValue(String task,String description){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("insert into atul(task,description) values("+"'"+task+"',"+"'"+description+"');");
        db.close();

    }

    public ArrayList<Model> readValues(){
        SQLiteDatabase db=getReadableDatabase();
       Cursor cursor= db.rawQuery("select * from atul;",null);
       ArrayList<Model> list=new ArrayList<>();
       if(cursor.moveToFirst()){
           do{
               list.add(new Model(cursor.getString(0),cursor.getString(1)));
           }while(cursor.moveToNext());
       }
       return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS atul");
        onCreate(sqLiteDatabase);
    }
}
