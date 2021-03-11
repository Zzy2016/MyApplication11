package com.example.appkotlin.activity.ui.home

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.appkotlin.LoadState
import com.example.appkotlin.R
import com.example.appkotlin.base.BaseFragment
import com.example.appkotlin.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    override fun getResLayoutId(): Int {
        Log.e("Fragment", baseBinding.flContent.childCount.toString() + "  ")
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    override fun bindViewModel() {
//        mDataBinding.viewModel = mViewModel
//        mViewModel.loadState.postValue(LoadState.LOADING)

        mViewModel.loadData()
    }


}