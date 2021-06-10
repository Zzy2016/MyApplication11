package com.example.testrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommAdapter extends RecyclerView.Adapter<CommViewHolder> {

    private List<String> list;


    public CommAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CommViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new CommViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommViewHolder holder, int position) {

        if(!holder.tv.getText().toString().equals("item")){
            Log.e("CommAdapter-->","重用了"+holder.tv.getText().toString()+"   写入"+list.get(position));
        }

        holder.tv.setText(position+"  ");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onViewRecycled(@NonNull CommViewHolder holder) {
        super.onViewRecycled(holder);
        Log.e("CommAdapter-->","onViewRecycled"+holder.tv.getText().toString()+"   position"+holder.getAdapterPosition());
    }
}
