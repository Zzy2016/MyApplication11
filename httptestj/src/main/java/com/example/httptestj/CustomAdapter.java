package com.example.httptestj;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httptestj.databinding.ItemBinding;

public class CustomAdapter extends RecyclerView.Adapter<CommonViewHolder> {




    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CommonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
