package com.example.myapplication11.ui.articlelist;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication11.BR;
import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseFragment;
import com.example.myapplication11.base.BaseViewModel;
import com.example.myapplication11.bean.responsebean.ArticleBean;
import com.example.myapplication11.config.Constants;
import com.example.myapplication11.databinding.FragmentArticleListBinding;
import com.example.myapplication11.databinding.FragmentHomeBinding;
import com.example.myapplication11.ui.nav.about.CommonAdapter;
import com.scwang.smart.refresh.header.ClassicsHeader;

/**
 *
 *
 *
 */
public class ArticleListFragment extends BaseFragment<FragmentHomeBinding, ArticleListViewModel> {

    private int type;
    private int id;

    public static ArticleListFragment newInstance(int type,int id){
        ArticleListFragment articleListFragment=new ArticleListFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(Constants.ParamCode.PARAM1, type);
        bundle.putInt(Constants.ParamCode.PARAM2, id);
        articleListFragment.setArguments(bundle);
        return articleListFragment;
    }

    @Override
    protected void handleArguments(Bundle args) {
        super.handleArguments(args);
        type = args.getInt(Constants.ParamCode.PARAM1);
        id = args.getInt(Constants.ParamCode.PARAM2);
    }

    @Override
    protected boolean isSupportLoad() {return true;

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewModel() {
        mViewModel=new ViewModelProvider(this).get(ArticleListViewModel.class);

    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected void init() {
        mViewModel.setType(type);
        mViewModel.setId(id);
        mViewModel.loadData();


    }

    private void initRefreshLayout() {
        mDataBinding.refreshLayout.setPrimaryColorsId(android.R.color.white, R.color.colorPrimary);
        mDataBinding.refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));
        mDataBinding.refreshLayout.setOnRefreshListener(refresh -> mViewModel.refreshData(true));
        mDataBinding.refreshLayout.setOnLoadMoreListener(refresh -> mViewModel.refreshData(false));
    }


    private void initRecyclerView() {

        CommonAdapter commonAdapter = new CommonAdapter<ArticleBean>(R.layout.item_article, BR.articleBean) {
            @Override
            public void addListener(View root, ArticleBean itemData, int position) {
                super.addListener(root, itemData, position);
//                root.findViewById(R.id.card_view).setOnClickListener(v -> DetailsActivity.start(getActivity(), itemData.getLink()));
//
//                root.findViewById(R.id.iv_collect).setOnClickListener(v -> {
//                    itemData.setCollect(!itemData.isCollect());
//                    notifyDataSetChanged();
//                    mViewModel.changeArticleCollect(itemData.isCollect(), itemData.getId());
//                });
            }
        };
//        mDataBinding.recycle.setAdapter(commonAdapter);
//        mDataBinding.recycle.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        mViewModel.getArticleList().observe(this, articleListBean -> {
//            if (articleListBean.getCurPage() >= articleListBean.getPageCount()) {
//                mDataBinding.refreshLayout.finishLoadMoreWithNoMoreData();
//            }
//            mDataBinding.refreshLayout.finishRefresh();
//            mDataBinding.refreshLayout.finishLoadMore();
//
//            commonAdapter.onItemDatasChanged(articleListBean.getDatas());
//        });
    }

    /**
     * 滚动到顶部
     */
    public void scrollToTop() {

        mDataBinding.recycle.smoothScrollToPosition(0);
    }

}