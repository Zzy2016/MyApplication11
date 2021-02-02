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
import com.example.myapplication11.databinding.FragmentHomeBinding;
import com.example.myapplication11.navinterface.ScrollToTop;
import com.example.myapplication11.ui.adapter.HomeAdapter;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.zhouwei.mzbanner.MZBannerView;

import java.util.List;


public class HomeFragment extends BaseFragment<FragmentHomeBinding, HomeViewModel> implements ScrollToTop {

    HomeAdapter commonAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected void init() {
        mViewModel.loadHomeData();

    }




    @Override
    public void scrollToTop() {
        mDataBinding.recycle.smoothScrollToPosition(0);
    }
}