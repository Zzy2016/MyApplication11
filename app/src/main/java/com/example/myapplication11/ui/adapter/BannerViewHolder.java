package com.example.myapplication11.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication11.R;
import com.example.myapplication11.bean.responsebean.HomeBanner;
import com.zhouwei.mzbanner.holder.MZViewHolder;



public class BannerViewHolder implements MZViewHolder<HomeBanner> {
    private ImageView mImageView;

    @Override
    public View createView(Context context) {
        View view= LayoutInflater.from(context).inflate(R.layout.remote_banner_item,null);
        mImageView=view.findViewById(R.id.remote_item_image);
        return view;
    }

    @Override
    public void onBind(Context context, int i, HomeBanner homeBanner) {
        Glide.with(context).load(homeBanner.getImagePath()).into(mImageView);
    }
}
