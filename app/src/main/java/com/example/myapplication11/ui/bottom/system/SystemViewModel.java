package com.example.myapplication11.ui.bottom.system;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.responsebean.WeChatBean;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.generated.callback.OnClickListener;
import com.example.myapplication11.http.data.HttpDisposable;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.HttpRequest;
import com.example.myapplication11.util.CommonUtils;
import com.example.myapplication11.util.NetworkUtils;

import java.util.List;

public class SystemViewModel extends BaseViewModel {

    private MutableLiveData<List<WeChatBean>> mSystemList;

    public SystemViewModel() {
        this.mSystemList = new MutableLiveData<>();
    }

    public MutableLiveData<List<WeChatBean>> getSystemList() {
        return mSystemList;
    }


    public void refreshData() {
        querySystemList();
    }

    @Override
    public void reloadData() {
        super.reloadData();
        loadData();
    }

    public void loadData() {
        loadState.postValue(LoadState.LOADING);
        querySystemList();
    }

    private void querySystemList() {
        if(!NetworkUtils.isConnected()){
            loadState.postValue(LoadState.NO_NETWORK);
            return;
        }

        HttpRequest.getInstance().getSystemList()
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<List<WeChatBean>>() {
                    @Override
                    public void success(List<WeChatBean> weChatBeans) {
                        if(!CommonUtils.isListEmpty(weChatBeans)){
                            loadState.postValue(LoadState.SUCCESS);
                            mSystemList.postValue(weChatBeans);
                        }else{
                            loadState.postValue(LoadState.NO_DATA);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        loadState.postValue(LoadState.ERROR);
                    }
                });
    }
}
