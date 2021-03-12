package com.example.appkotlin.activity.ui.home

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.fastjson.JSON
import com.example.appkotlin.LoadState
import com.example.appkotlin.R
import com.example.appkotlin.base.BaseFragment
import com.example.appkotlin.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    override fun getResLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    override fun bindViewModel() {
//        mDataBinding.viewModel = mViewModel
//        mViewModel.loadState.postValue(LoadState.LOADING)

        mViewModel.loadData()


        mViewModel.mutableBanner.observe(this, { (banner) ->


            Log.e("banner--->2", JSON.toJSON(banner).toString())

        })

    }

    override fun initView() {
        mDataBinding.root.setOnClickListener { mViewModel.loadState.postValue(LoadState.SUCCESS) }
    }


}


