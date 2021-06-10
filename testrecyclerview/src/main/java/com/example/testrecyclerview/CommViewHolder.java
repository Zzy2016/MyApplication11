package com.example.testrecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommViewHolder extends RecyclerView.ViewHolder {
    public TextView tv, tvDelete, tvInsert;

    public CommViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.tvItem);
        tvDelete = itemView.findViewById(R.id.tvDelete);
        tvInsert = itemView.findViewById(R.id.tvInsert);
    }
}
