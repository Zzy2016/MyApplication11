package com.example.myapplication11.ui.bottom.wechat;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseFragment;
import com.example.myapplication11.bean.responsebean.WeChatBean;
import com.example.myapplication11.config.Constants;
import com.example.myapplication11.databinding.FragmentViewPagerBinding;
import com.example.myapplication11.navinterface.ScrollToTop;
import com.example.myapplication11.ui.adapter.ArticleListPagerAdapter;

import java.util.List;


public class WeChatFragment extends BaseFragment<FragmentViewPagerBinding, WeChatViewModel> implements ScrollToTop {

    private ArticleListPagerAdapter mPagerAdapter;
    private List<WeChatBean> mList;
    private int pos;

    @Override
    protected void handleArguments(Bundle args) {
        super.handleArguments(args);
        pos = args.getInt(Constants.ParamCode.PARAM2, 0);
        mList = (List<WeChatBean>) args.getSerializable(Constants.ParamCode.PARAM1);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_view_pager;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(WeChatViewModel.class);
    }

    @Override
    protected void bindViewModel() {
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected boolean isSupportLoad() {
        return true;
    }

    @Override
    protected void init() {

        if (mList != null) {
            mViewModel.setDataList(mList);
        } else {
            mViewModel.loadWeChatList();
        }

        mPagerAdapter = new ArticleListPagerAdapter(getChildFragmentManager());
        mDataBinding.viewPager.setAdapter(mPagerAdapter);
        mDataBinding.tabTitle.setupWithViewPager(mDataBinding.viewPager);
        mDataBinding.viewPager.setCurrentItem(pos);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPagerAdapter != null) {
            mPagerAdapter.release();
        }
    }


    @Override
    public void scrollToTop() {

    }
}