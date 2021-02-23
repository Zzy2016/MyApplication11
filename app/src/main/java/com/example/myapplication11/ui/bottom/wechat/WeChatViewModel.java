package com.example.myapplication11.ui.bottom.wechat;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.responsebean.WeChatBean;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.http.data.HttpDisposable;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.HttpRequest;
import com.example.myapplication11.util.NetworkUtils;

import java.util.List;

public class WeChatViewModel extends BaseViewModel {

    public ObservableList<WeChatBean> dataList;

    public WeChatViewModel() {
        dataList = new ObservableArrayList<>();
    }


    public void setDataList(List<WeChatBean> dataList) {
        dataList.addAll(dataList);
    }

    //获取公众号内tabTitle
    public void loadWeChatList() {
        if (!NetworkUtils.isConnected()) {
            loadState.postValue(LoadState.ERROR);
            return;
        }
        loadState.postValue(LoadState.LOADING);
        HttpRequest.getInstance().getWechatList()
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<List<WeChatBean>>() {
                    @Override
                    public void success(List<WeChatBean> weChatBeans) {
                        if (weChatBeans.size() > 0) {
                            dataList.addAll(weChatBeans);
                            loadState.postValue(LoadState.SUCCESS);
                        } else {
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
