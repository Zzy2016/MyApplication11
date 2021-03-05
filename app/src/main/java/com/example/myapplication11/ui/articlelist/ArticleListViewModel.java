package com.example.myapplication11.ui.articlelist;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.responsebean.ArticleBean;
import com.example.myapplication11.bean.responsebean.ArticleListBean;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.http.data.HttpDisposable;
import com.example.myapplication11.http.request.HttpFactory;
import com.example.myapplication11.http.request.HttpRequest;
import com.example.myapplication11.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleListViewModel extends BaseViewModel {

    private int mType = 0;
    private int mPage = 0;
    private int mId = 0;
    private MutableLiveData<ArticleListBean> mArticleList;
    private List<ArticleBean> mList;

    public ArticleListViewModel() {
        this.mArticleList = new MediatorLiveData<>();
        this.mList = new ArrayList<>();
    }

    public void setType(int mType) {
        this.mType = mType;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public LiveData<ArticleListBean> getArticleList() {
        return mArticleList;
    }

    //刷新
    public void refreshData(Boolean refresh) {
        if (refresh) {
            mPage = 0;
        } else {
            mPage++;
        }

        mRefresh = true;
        loadArticleList();
    }

    //重新加载
    @Override
    public void reloadData() {
        loadData();
        Log.e("加载数据","刷新数据");
    }

    //第一次加载数据
    public void loadData() {
        Log.e("加载数据","加载数据");
        loadState.postValue(LoadState.LOADING);
        mPage = 0;
        mRefresh = false;
        loadArticleList();
    }

    //加载文章列表
    private void loadArticleList() {
        if (!NetworkUtils.isConnected()) {
            loadState.postValue(LoadState.NO_NETWORK);
            return;
        }
        if (mType == 0) {
            loadWeChatArticleList();
        } else if (mType == 1) {
            loadSystemArticleList();
        } else {
            loadProjectArticleList();
        }
    }

    //加载微信公众号数据
    private void loadWeChatArticleList() {
        mPage++;
        HttpRequest.getInstance().getWechatArticleList(mId, mPage)
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<ArticleListBean>() {
                    @Override
                    public void success(ArticleListBean articleListBean) {
                        if (articleListBean != null) {
                            loadState.postValue(LoadState.SUCCESS);
                            if (mPage == 1) {
                                mList.clear();
                                mList.addAll(articleListBean.getDatas());
                                mArticleList.postValue(articleListBean);
                            } else {
                                mList.addAll(articleListBean.getDatas());
                                articleListBean.setDatas(mList);
                                mArticleList.postValue(articleListBean);
                            }
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

    //加载体系文章数据
    private void loadSystemArticleList() {
        HttpRequest.getInstance().getSystemArticle(mPage, mId)
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<ArticleListBean>() {
                    @Override
                    public void success(ArticleListBean articleListBean) {
                        if (articleListBean != null) {
                            loadState.postValue(LoadState.SUCCESS);

                            if (mPage == 0) {
                                //第一次加载或刷新成功
                                //清空列表，重新载入数据，设置刷新成功状态
                                mList.clear();
                                mList.addAll(articleListBean.getDatas());
                                mArticleList.postValue(articleListBean);


                            } else {
                                //下拉加载更多成功
                                //添加数据，设置下拉加载成功状态
                                mList.addAll(articleListBean.getDatas());
                                articleListBean.setDatas(mList);
                                mArticleList.postValue(articleListBean);
                            }
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

    //加载项目文章数据
    private void loadProjectArticleList() {
        mPage++;
        HttpRequest.getInstance().getProjectArticle(mPage, mId)
                .compose(HttpFactory.schedulers())
                .subscribe(new HttpDisposable<ArticleListBean>() {
                    @Override
                    public void success(ArticleListBean articleListBean) {
                        if (mArticleList != null) {
                            loadState.postValue(LoadState.SUCCESS);
                            if (mPage == 1) {
                                mList.clear();
                                mList.addAll(articleListBean.getDatas());
                                mArticleList.postValue(articleListBean);
                            } else {
                                mList.addAll(articleListBean.getDatas());
                                articleListBean.setDatas(mList);
                                mArticleList.postValue(articleListBean);
                            }
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
