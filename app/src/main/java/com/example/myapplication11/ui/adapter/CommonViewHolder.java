package com.example.myapplication11.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class CommonViewHolder extends RecyclerView.ViewHolder {
    ViewDataBinding binding;

    public CommonViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
