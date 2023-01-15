package com.example.calculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<String> students;

    public RecyclerAdapter(ArrayList<String> students) {
        this.students = students;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView rvTextView;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            rvTextView = itemView.findViewById(R.id.rvtextView);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String currentStudent = students.get(position);
        holder.rvTextView.setText(currentStudent);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}