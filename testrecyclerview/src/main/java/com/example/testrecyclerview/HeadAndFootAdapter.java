package com.example.testrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeadAndFootAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> list;

    private int headCount = 0;
    private int footCount = 0;

    private int HEADER = 0;
    private int ITEM = 1;
    private int FOOTER = 2;


    public HeadAndFootAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("item" + i);
        }
    }

    public HeadAndFootAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (headCount > 0 && position < headCount) {
            return HEADER;
        } else if (footCount > 0 && position > (list.size() + headCount)) {
            return FOOTER;
        } else {
            return ITEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ItemViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_or_foot, parent, false);
            return new HeadOrFootHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).tvItem.setText(position + "  " + list.get(position - headCount));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position-headCount+" item", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof HeadOrFootHolder) {
            if (position < headCount) {
                ((HeadOrFootHolder) holder).tv1.setVisibility(View.GONE);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "head", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                ((HeadOrFootHolder) holder).tv.setVisibility(View.GONE);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "foot", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + headCount + footCount;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }

    public class HeadOrFootHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public TextView tv1;

        public HeadOrFootHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

}
