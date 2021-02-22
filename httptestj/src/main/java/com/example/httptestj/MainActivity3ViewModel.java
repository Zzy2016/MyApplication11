package com.example.httptestj;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivity3ViewModel extends ViewModel {

    public MutableLiveData<String> para = new MutableLiveData<>();

    public MainActivity3ViewModel() {
        para.postValue("test");
    }

    public void tvClick(View view) {
        Log.e("--------", "tvClick");
    }

    public void tvClick1(String item) {
        Log.e("--------", "tvClick1  "+item);
    }


}
