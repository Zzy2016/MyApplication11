package com.example.myapplication11.base;

import android.content.res.Resources;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication11.R;
import com.example.myapplication11.config.App;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.http.data.HttpDisposable;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.HttpRequest;



public abstract  class BaseViewModel extends ViewModel implements DefaultLifecycleObserver {
    public Resources resources;
    public MutableLiveData<Object> collect=new MutableLiveData<>();
    public MutableLiveData<LoadState> loadState=new MutableLiveData<>();
    public MutableLiveData<String> errorMsg=new MutableLiveData<>(getResources().getString(R.string.load_error));

    public boolean mRefresh;

    public void reloadData(){

    }

    public LiveData<Object> getCollect() {
        return collect;
    }

    public Resources getResources() {
        if(resources==null){
            resources= App.getContext().getResources();
        }
        return resources;
    }

//    改变文章收藏
    public void changeArticleCollect(boolean collect,int id){
        if(collect){
            collectArticle(id);
        }else{
            unCollectArticle(id);
        }
    }


//    收藏文章
    private void collectArticle(int id){
        HttpRequest.getInstance().collectArticle(id)
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<Object>() {
                    @Override
                    public void success(Object o) {
                        collect.postValue(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        collect.postValue(null);
                    }
                });
    }

//    取消收藏
    private void unCollectArticle(int id){
        HttpRequest.getInstance().unCollectArticle(id)
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<Object>() {
                    @Override
                    public void success(Object o) {
                        collect.postValue(o);
                    }

                    @Override
                    public void onError(Throwable e) {
//                        super.onError(e);
                        collect.postValue(null);
                    }
                });
    }

}
