package com.example.myapplication11.ui.articlelist;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseFragment;
import com.example.myapplication11.bean.responsebean.ArticleBean;
import com.example.myapplication11.config.Constants;
import com.example.myapplication11.databinding.FragmentListBinding;
import com.example.myapplication11.ui.adapter.CommonAdapter;


public class ArticleListFragment extends BaseFragment<FragmentListBinding, ArticleListViewModel> {


    private int type;
    private int id;

    public static ArticleListFragment newInstance(int type, int id) {
        ArticleListFragment fragment = new ArticleListFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.ParamCode.PARAM1, type);
        args.putInt(Constants.ParamCode.PARAM2, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void handleArguments(Bundle args) {
        super.handleArguments(args);
        type = args.getInt(Constants.ParamCode.PARAM1);
        id = args.getInt(Constants.ParamCode.PARAM2);
    }

    @Override
    protected boolean isSupportLoad() {
        return true;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(ArticleListViewModel.class);

    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected void init() {
    }

    private void initRefreshLayout() {

    }

    private void initRecyclerView() {
        CommonAdapter commonAdapter = new CommonAdapter<ArticleBean>(R.layout.item_article, BR.articleBean) {
            @Override
            public void addListener(View root, ArticleBean itemData, int position) {
                super.addListener(root, itemData, position);

            }
        };

        mDataBinding.recycle.setAdapter(commonAdapter);
        mDataBinding.recycle.setLayoutManager(new LinearLayoutManager(getContext()));




    }

    public void scrollToTop() {
        mDataBinding.recycle.smoothScrollToPosition(0);
    }

}