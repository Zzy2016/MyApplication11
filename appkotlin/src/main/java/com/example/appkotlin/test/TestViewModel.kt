package com.example.appkotlin.test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TestViewModel :ViewModel(){
    val banner= MutableLiveData<BannerModel>()
    fun launchOnUI(block:suspend CoroutineScope.()->Unit){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                block()
            }
        }
    }
}