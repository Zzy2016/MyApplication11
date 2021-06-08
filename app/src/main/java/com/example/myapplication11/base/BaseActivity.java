package com.example.myapplication11.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.myapplication11.R;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.databinding.ActivityBaseBinding;
import com.example.myapplication11.databinding.ViewLoadErrorBinding;
import com.example.myapplication11.databinding.ViewLoadingBinding;
import com.example.myapplication11.databinding.ViewNoDataBinding;
import com.example.myapplication11.databinding.ViewNoNetworkBinding;

import java.sql.BatchUpdateException;

public abstract class BaseActivity<DB extends ViewDataBinding,VM extends BaseViewModel> extends AppCompatActivity {
    public DB mDataBinding;
    protected VM mViewModel;

    private ActivityBaseBinding mActivityBaseBinding;
    private ViewLoadingBinding mViewLoadingBinding;
    private ViewLoadErrorBinding mViewLoadErrorBinding;
    private ViewNoNetworkBinding mViewNoNetworkBinding;
    private ViewNoDataBinding mViewNoDataBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());

        if(isNoActionBar()){
            setNoActivityBar();
        }

        mActivityBaseBinding=DataBindingUtil.setContentView(this,R.layout.activity_base);
        mDataBinding=DataBindingUtil.inflate(getLayoutInflater(),getLayoutResId(),mActivityBaseBinding.flContentContainer,true);
        initViewModel();
        bindViewModel();

        mDataBinding.setLifecycleOwner(this);
        initLoadState();
        init();

        if(mViewModel!=null){
            getLifecycle().addObserver(mViewModel);
        }

    }

    public void setNoActivityBar(){
        Window window=getWindow();
        View decorView=window.getDecorView();
        int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        if(Build.VERSION.SDK_INT> Build.VERSION_CODES.LOLLIPOP){
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initLoadState(){
        if(mViewModel!=null&&isSupportLoad()){
            mViewModel.loadState.observe(this, new Observer<LoadState>() {
                @Override
                public void onChanged(LoadState loadState) {
                    switchLoadView(loadState);
                }
            });
        }
    }


    private void removeLoadView(){
       int childCount=mActivityBaseBinding.flContentContainer.getChildCount();
       if(childCount>1){
           mActivityBaseBinding.flContentContainer.removeViews(1,childCount-1);
       }
    }

    private void switchLoadView(LoadState loadState){
        removeLoadView();
        switch (loadState){
            case LOADING:
                if (mViewLoadingBinding == null) {
                    mViewLoadingBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_loading,
                            mActivityBaseBinding.flContentContainer, false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewLoadingBinding.getRoot());
                break;
            case NO_NETWORK:
                if (mViewNoNetworkBinding == null) {
                    mViewNoNetworkBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_network,
                            mActivityBaseBinding.flContentContainer, false);
                    mViewNoNetworkBinding.setViewModel(mViewModel);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewNoNetworkBinding.getRoot());
                break;
            case NO_DATA:
                if (mViewNoDataBinding == null) {
                    mViewNoDataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_data,
                            mActivityBaseBinding.flContentContainer, false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewNoDataBinding.getRoot());
                break;

            case ERROR:
                if (mViewLoadErrorBinding == null) {
                    mViewLoadErrorBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_load_error,
                            mActivityBaseBinding.flContentContainer, false);
                }
                mActivityBaseBinding.flContentContainer.addView(mViewLoadErrorBinding.getRoot());
                break;

            default:
                break;
        }
    }


    protected void handleIntent(Intent intent){

    }

    protected boolean isNoActionBar(){
        return false;
    }

    protected boolean isSupportLoad(){
        return false;
    }

    protected abstract int getLayoutResId();


    protected abstract void initViewModel();

    protected abstract void bindViewModel();

    protected abstract void init();



}
