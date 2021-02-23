package com.example.httptestj;

import android.provider.ContactsContract;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class CommonViewHolder<DB extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private final DB binding;

    public DB getBinding() {
        return binding;
    }


    public CommonViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}
