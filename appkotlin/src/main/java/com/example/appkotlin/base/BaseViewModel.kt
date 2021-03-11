package com.example.appkotlin.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appkotlin.LoadState

abstract class BaseViewModel : ViewModel() {


    var loadState = MutableLiveData<LoadState>()


    //开始加载数据
    abstract fun loadData()

    //刷新数据
    abstract fun refreshData()

    //重新获取数据
    abstract fun reLoadData()


}