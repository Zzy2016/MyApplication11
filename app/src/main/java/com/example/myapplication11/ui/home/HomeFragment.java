package com.example.myapplication11.ui.home;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseFragment;
import com.example.myapplication11.bean.responsebean.ArticleBean;
import com.example.myapplication11.bean.responsebean.home.HomeData;
import com.example.myapplication11.databinding.FragmentListBinding;
import com.example.myapplication11.navinterface.ScrollToTop;
import com.example.myapplication11.ui.adapter.HomeAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.zhouwei.mzbanner.MZBannerView;

import java.util.List;


public class HomeFragment extends BaseFragment<FragmentListBinding, HomeViewModel> implements ScrollToTop {


    private HomeAdapter commonAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        initDataChange();


    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected boolean isSupportLoad() {
        return true;
    }

    @Override
    protected void init() {
        mViewModel.loadHomeData();

        initRecycle();
        initRefreshLayout();

    }


    private void initRefreshLayout() {

        mDataBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mViewModel.refreshData(true);
            }
        });


        mDataBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mViewModel.refreshData(false);
            }
        });
    }


    private void initRecycle() {
        commonAdapter = new HomeAdapter() {
            @Override
            public void addListener(View root, HomeData itemData, int position) {
                super.addListener(root, itemData, position);
                if (itemData.getBannerData() != null) {
                    MZBannerView banner = root.findViewById(R.id.banner);
                    banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
                        @Override
                        public void onPageClick(View view, int i) {
                            String url = itemData.getBannerData().getBannerData().get(i).getUrl();
                        }
                    });
                } else if (itemData.getTopArticleList() != null) {

                } else {
                    root.findViewById(R.id.card_view).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    root.findViewById(R.id.iv_collect).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            itemData.getArticleList().setCollect(!itemData.getArticleList().isCollect());
                            notifyDataSetChanged();
                            mViewModel.changeArticleCollect(itemData.getArticleList().isCollect(), itemData.getArticleList().getId());
                        }
                    });
                }
            }


            @Override
            public void addTopClickListener(ArticleBean itemData) {
                super.addTopClickListener(itemData);

            }

            @Override
            public void addTopCollectListener(ArticleBean itemData) {
                super.addTopCollectListener(itemData);
                mViewModel.changeArticleCollect(itemData.isCollect(), itemData.getId());
            }
        };
        mDataBinding.recycle.setLayoutManager(new LinearLayoutManager(getContext()));
        mDataBinding.recycle.setAdapter(commonAdapter);
    }

    private void initDataChange() {
        mViewModel.getHomeList().observe(this, new Observer<List<HomeData>>() {
            @Override
            public void onChanged(List<HomeData> homeData) {
                commonAdapter.onItemDatasChanged(homeData);
                mDataBinding.refreshLayout.finishRefresh();
                mDataBinding.refreshLayout.finishLoadMore();
            }
        });
    }

    @Override
    public void scrollToTop() {
        mDataBinding.recycle.smoothScrollToPosition(0);
    }
}