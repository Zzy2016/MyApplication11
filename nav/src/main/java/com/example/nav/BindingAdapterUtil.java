package com.example.nav;

import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.List;

public class BindingAdapterUtil {

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int padding) {
        view.setPadding(padding,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }

    @BindingAdapter({"image", "error"})
    public static void loadImage(ImageView imageView, String url, String error) {

    }

    @BindingAdapter("android:onLayoutChange")
    public static void setOnLayoutChangeListener(View view, View.OnLayoutChangeListener oldValue, View.OnLayoutChangeListener newValue) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (oldValue != null) {
                view.removeOnLayoutChangeListener(oldValue);
            }
            if (newValue != null) {
                view.addOnLayoutChangeListener(newValue);
            }
        }
    }

    @BindingAdapter("android:images")
    public static void bannerGetImage(MZBannerView banner, BannerData bannerData) {
        if (bannerData == null || bannerData.getList() == null) {
            return;
        }

        List<ImageBean> images = bannerData.getList();
        banner.setPages(images, new MZHolderCreator<MainActivity4.BannerViewHolder>() {
            @Override
            public MainActivity4.BannerViewHolder createViewHolder() {
                return new MainActivity4.BannerViewHolder();
            }
        });
        banner.start();
    }


}
