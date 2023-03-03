package com.example.todo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<Model> list;
    public MyAdapter(Context context,ArrayList<Model> list){
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Model model=list.get(position);
    holder.task.setText(model.task);
    holder.description.setText(model.description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView task,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            task=itemView.findViewById(R.id.task);
            description=itemView.findViewById(R.id.description);

        }
    }
}
