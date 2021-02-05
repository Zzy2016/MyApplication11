package com.example.myapplication11.ui.home;

import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseFragment;
import com.example.myapplication11.databinding.FragmentListBinding;
import com.example.myapplication11.navinterface.ScrollToTop;
import com.example.myapplication11.ui.adapter.HomeAdapter;


public class HomeFragment extends BaseFragment<FragmentListBinding, HomeViewModel> implements ScrollToTop {


    HomeAdapter commonAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
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

    }

    @Override
    public void scrollToTop() {

    }
}