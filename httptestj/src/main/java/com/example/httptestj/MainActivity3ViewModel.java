package com.example.httptestj;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;

public class MainActivity3ViewModel extends ViewModel {

    public MutableLiveData<String> para = new MutableLiveData<>();

    public MainActivity3ViewModel() {
        para.postValue("test");
    }

    public String imgUrl="http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg";
    public void tvClick(View view) {
        Log.e("--------", "tvClick");
    }

    public void tvClick1(String item) {
        Log.e("--------", "tvClick1  " + item);
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view).load(url).into(view);
    }


}
