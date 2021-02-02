package com.example.myapplication11.ui.activity.splash;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.ActivitySkip;
import com.example.myapplication11.bean.responsebean.ImageBean;
import com.example.myapplication11.http.data.HttpDisposable;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.HttpRequest;
import com.example.myapplication11.http.request.ServerAddress;
import com.example.myapplication11.util.NetworkUtils;
import com.google.android.material.internal.ManufacturerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class SplashViewModel extends BaseViewModel {
    private MutableLiveData<ImageBean> mImage;
    private MutableLiveData<String> mTimer;
    private MutableLiveData<ActivitySkip> mActivitySkip;
    private String url;


    @Override
    public void onStart(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);

        startTimer();
        loadImageView();
    }

    public void loadImageView(){
        if(!NetworkUtils.isConnected()){
            mImage.postValue(null);
        }else{
            HttpRequest.getInstance(ServerAddress.API_BING)
                    .getImage("js",0,1)
                    .compose(HttpFactory.<ImageBean>schedulers())
                    .subscribe(new HttpDisposable<ImageBean>() {
                        @Override
                        public void success(ImageBean imageBean) {
                            mImage.postValue(imageBean);
                            Log.e("----------->",imageBean.toString());
                            url=imageBean.getImages().get(0).getCopyrightlink();
                        }

                        @Override
                        public void onError(Throwable e) {
                            super.onError(e);
                            Log.e("----------->1",e.toString());
                            mImage.postValue(null);
                        }
                    });
        }
    }

    public void startTimer() {
        List<String> list = new ArrayList<>();
        for (int i = 4; i >= 0; i--) {
            list.add(i + "S");
        }

        Observable<String> observable = Observable.fromIterable(list);
        Observable<Long> time = Observable.interval(1, TimeUnit.SECONDS);
        Observable.zip(observable, time, new BiFunction<String, Long, String >() {
            @Override
            public String apply(String s, Long aLong) throws Exception {
                return s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                if ("0S".equals(s)) {
                    startMainActivity();
                }
                Log.e("计时",s);
                mTimer.postValue("跳过："+s);
            }
        });
    }

    public void startSplashImageDetail(){
        ActivitySkip skip = new ActivitySkip();
        skip.setmActivity("DetailActivity");
        skip.setParam1(url);
        mActivitySkip.postValue(skip);
    }

    public void startMainActivity(){
        ActivitySkip activitySkip=new ActivitySkip();
        activitySkip.setmActivity("MainActivity");
        mActivitySkip.postValue(activitySkip);
    }

    public SplashViewModel() {
        mActivitySkip = new MutableLiveData<>();
        mImage = new MutableLiveData<>();
        mTimer = new MutableLiveData<>();
        mTimer.postValue("跳过：5S");
    }

    public LiveData<ImageBean> getImage() {
        return mImage;
    }

    public LiveData<String> getTimer() {
        return mTimer;
    }

    public LiveData<ActivitySkip> getActivitySkip() {
        return mActivitySkip;
    }
}
