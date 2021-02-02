package com.example.myapplication11.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication11.R;
import com.example.myapplication11.config.App;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class GlideUtil {
    public static void loadImageWithDefault(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_logo)
                .error(R.mipmap.ic_logo).fallback(R.mipmap.ic_logo)
                .transform(new CircleCrop());

        Glide.with(App.getContext())
                .load(url)
                .apply(options)
                .into(imageView);
    }


    public static void loadImageWithGoss(ImageView imageView, String url) {
        Glide.with(App.getContext())
                .load(url)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3)))
                .into(imageView);
    }
}
