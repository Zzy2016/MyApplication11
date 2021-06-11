package com.example.testrecyclerview;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommImgAdapter extends RecyclerView.Adapter<CommImgAdapter.ViewHolder> {


    private Context context;

    public CommImgAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
        for (int i = 0; i < 51; i++) {
            list.add("item--" + i);
        }
    }

    private List<String> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_item, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        int allWidth = context.getDisplay().getWidth();
        layoutParams.width = (allWidth - 20 * 2 - 10 * 2) / 3;
        layoutParams.height = layoutParams.width + new Random().nextInt(200);
        holder.itemView.setLayoutParams(layoutParams);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
