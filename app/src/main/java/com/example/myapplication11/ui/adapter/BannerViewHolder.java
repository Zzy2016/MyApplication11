package com.example.myapplication11.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication11.R;
import com.example.myapplication11.bean.responsebean.HomeBanner;
import com.zhouwei.mzbanner.holder.MZViewHolder;

public class BannerViewHolder implements MZViewHolder<HomeBanner> {
    private ImageView mImageView;

    @Override
    public View createView(Context context) {
        View view= LayoutInflater.from(context).inflate(R.layout.remote)
        return null;
    }

    @Override
    public void onBind(Context context, int i, HomeBanner homeBanner) {

    }
}
