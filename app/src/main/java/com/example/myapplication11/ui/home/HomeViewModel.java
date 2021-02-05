package com.example.myapplication11.ui.home;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.responsebean.home.HomeData;
import com.example.myapplication11.config.LoadState;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends BaseViewModel {

    private MutableLiveData<List<HomeData>> mHomeList;
    private List<HomeData> mList;

    private int mPageNum;

    public HomeViewModel() {
        mHomeList = new MutableLiveData<>();
        mList = new ArrayList<>();
    }

    public MutableLiveData<List<HomeData>> getmHomeList() {
        return mHomeList;
    }

    public void setmHomeList(MutableLiveData<List<HomeData>> mHomeList) {
        this.mHomeList = mHomeList;
    }

    public List<HomeData> getmList() {
        return mList;
    }

    public void setmList(List<HomeData> mList) {
        this.mList = mList;
    }

    @Override
    public void reloadData() {
        super.reloadData();
    }

    public void loadHomeData() {
        if (!mRefresh) {
            loadState.setValue(LoadState.LOADING);
        }
        mPageNum = 0;

    }

    public void refreshData(boolean refresh) {

    }

    private void loadBanner() {

    }

    private void loadBannerByNet() {

    }

    private void loadBannerByDb() {

    }

    private void loadTopArticleList() {

    }

    private void loadArticleList(int page) {

    }

}
