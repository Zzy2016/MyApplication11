package com.example.myapplication11.ui.activity.splash;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseActivity;
import com.example.myapplication11.bean.ActivitySkip;
import com.example.myapplication11.bean.responsebean.ImageBean;
import com.example.myapplication11.config.App;
import com.example.myapplication11.config.Constants;
import com.example.myapplication11.databinding.ActivitySplashBinding;
import com.example.myapplication11.ui.activity.detail.DetailActivity;
import com.example.myapplication11.ui.activity.main.MainActivity;
import com.orhanobut.hawk.Hawk;

public class SplashActivity extends BaseActivity<ActivitySplashBinding,SplashViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.firstOpen=true;
//        setContentView(R.layout.activity_splash);
    }

    @Override
    protected boolean isNoActionBar() {
        return true;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViewModel() {
        mViewModel=new ViewModelProvider(this).get(SplashViewModel.class);
    }

    @Override
    protected void bindViewModel() {
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected void init() {
        mViewModel.getImage().observe(this, new Observer<ImageBean>() {
            @Override
            public void onChanged(ImageBean imageBean) {
                if(imageBean!=null){
                    String url=imageBean.getImages().get(0).getBaseUrl()+imageBean.getImages().get(0).getUrl();
                    Glide.with(SplashActivity.this).load(url).into(mDataBinding.ivSplash);
                    Hawk.put(Constants.HawkCode.SPLASH_IMAGE_URL,url);
                }else{
                    Glide.with(SplashActivity.this)
                            .load(R.mipmap.splash_bg)
                            .into(mDataBinding.ivSplash);
                }
            }
        });

        mViewModel.getActivitySkip().observe(this, new Observer<ActivitySkip>() {
            @Override
            public void onChanged(ActivitySkip activitySkip) {
                if("DetailsActivity".equals(activitySkip.getmActivity())){

                }else if("MainActivity".equals(activitySkip.getmActivity())){
                    MainActivity.start(SplashActivity.this,false);
                    finish();
                }
            }
        });
    }
}