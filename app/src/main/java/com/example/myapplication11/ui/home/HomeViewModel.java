package com.example.myapplication11.ui.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.responsebean.ArticleBean;
import com.example.myapplication11.bean.responsebean.ArticleListBean;
import com.example.myapplication11.bean.responsebean.HomeBanner;
import com.example.myapplication11.bean.responsebean.home.BannerData;
import com.example.myapplication11.bean.responsebean.home.HomeData;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.http.data.HttpDisposable;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.HttpRequest;
import com.example.myapplication11.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends BaseViewModel {

    private MutableLiveData<List<HomeData>> mHomeList;
    private List<HomeData> mList;

    //页码
    private int mPageNum;

    public HomeViewModel() {
        mHomeList = new MutableLiveData<>();
        mList = new ArrayList<>();
    }

    public MutableLiveData<List<HomeData>> getHomeList() {
        return mHomeList;
    }

    public void setHomeList(MutableLiveData<List<HomeData>> mHomeList) {
        this.mHomeList = mHomeList;
    }

    public List<HomeData> getList() {
        return mList;
    }

    public void setList(List<HomeData> mList) {
        this.mList = mList;
    }

    @Override
    public void reloadData() {
        super.reloadData();
        loadHomeData();
    }

    public void loadHomeData() {
        if (!mRefresh) {
            loadState.setValue(LoadState.LOADING);
        }
        mPageNum = 0;
        loadBanner();
    }

    public void refreshData(boolean refresh) {
        mRefresh = true;
        if (refresh) {
            mPageNum = 0;
            loadHomeData();
        } else {
            mPageNum++;
            loadArticleList(mPageNum);
        }
    }

    private void loadBanner() {
        if (NetworkUtils.isConnected() && NetworkUtils.getWifiEnabled()) {
            loadBannerByNet();
        } else {
            loadBannerByDb();
        }
    }

    //获取banner
    private void loadBannerByNet() {
        HttpRequest.getInstance().getBanner().compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<List<HomeBanner>>() {
                    @Override
                    public void success(List<HomeBanner> homeBanners) {
                        mList.clear();
                        HomeData homeData=new HomeData();
                        homeData.setBannerData(new BannerData(homeBanners));
                        mList.add(homeData);

                        if(!mRefresh){
                            loadState.postValue(LoadState.SUCCESS);
                        }

                        loadTopArticleList();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        loadTopArticleList();
                    }
                });
    }

    private void loadBannerByDb() {

    }

    //获取置顶文章
    private void loadTopArticleList() {
        HttpRequest.getInstance().getTopArticleList()
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<List<ArticleBean>>() {
                    @Override
                    public void success(List<ArticleBean> articleBeans) {
                        Log.e("获取文章",articleBeans.toString() +(articleBeans!=null&&articleBeans.size() == 0));
                        if (articleBeans != null && articleBeans.size() != 0) {
                            HomeData homeData = new HomeData();
                            HomeData.TopArticle topArticle = new HomeData.TopArticle();
                            topArticle.setName("置顶文章");
                            topArticle.setArticleBeanList(articleBeans);
                            homeData.setTopArticleList(topArticle);
                            mList.add(homeData);


                            loadArticleList(0);
                            if (!mRefresh) {
                                loadState.postValue(LoadState.SUCCESS);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        loadArticleList(0);
                    }
                });
    }

    //    获取首页文章列表
    private void loadArticleList(int page) {
        HttpRequest.getInstance()
                .getArticleList(page)
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<ArticleListBean>() {
                    @Override
                    public void success(ArticleListBean articleListBean) {
                        if (articleListBean.getDatas() != null && articleListBean.getDatas().size() != 0) {
                            for (ArticleBean bean : articleListBean.getDatas()) {
                                HomeData homeData = new HomeData();
                                homeData.setArticleList(bean);
                                mList.add(homeData);
                            }
                            List<HomeData> homeData = new ArrayList<>();
                            homeData.addAll(mList);
                            mHomeList.postValue(homeData);
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
