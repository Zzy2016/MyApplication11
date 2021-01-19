package com.example.myapplication11.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.multidex.MultiDexApplication;


import com.bumptech.glide.Glide;
import com.example.myapplication11.R;
import com.example.myapplication11.http.data.HttpBaseResponse;
import com.example.myapplication11.http.data.HttpResponseInterface;
import com.example.myapplication11.http.httptool.HttpException;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.ServerAddress;
import com.example.myapplication11.manager.MyActivityManager;
import com.google.gson.Gson;
import com.guoxiaoxing.phoenix.core.listener.ImageLoader;
import com.guoxiaoxing.phoenix.picker.Phoenix;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshInitializer;


public class App extends MultiDexApplication {


    private static Context context;
    public static boolean firstOpen;


    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        firstOpen=true;
        context=this;
        initActivityManager();
        init();

    }

    private void initActivityManager(){
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                MyActivityManager.getsInstance().setsCurrentActivityWeakRef(activity);
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {

            }
        });
    }

    private void init(){
        Hawk.init(context).build();
        setHttpConfig();
        Phoenix.config().imageLoader(new ImageLoader() {
            @Override
            public void loadImage(Context context, ImageView imageView, String imagePath, int type) {
                Glide.with(context).load(imagePath).into(imageView);
            }
        });
    }

    private static void setHttpConfig(){
        HttpFactory.HTTP_HOST_URL= ServerAddress.getApiDefaultHost();
        HttpFactory.httpResponseInterface=new HttpResponseInterface() {
            @Override
            public String getResponseData(Gson gson, String response) {
                if(firstOpen){
                    firstOpen=false;
                    return response;
                }
                HttpBaseResponse httpBaseResponse=gson.fromJson(response,HttpBaseResponse.class);
                if(httpBaseResponse.errorCode!=0){
                    throw new HttpException(httpBaseResponse.errorCode,httpBaseResponse.errorMsg);
                }
                return gson.toJson(httpBaseResponse.data);
            }
        };
    }

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary,android.R.color.white);
                return new ClassicsHeader(context);
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {

                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });

        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setEnableFooterFollowWhenLoadFinished(true);
                layout.setEnableAutoLoadMore(false);
            }
        });

    }


}
