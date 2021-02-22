package com.example.viewmodeltest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserModel extends ViewModel {
    private final MutableLiveData<String> user = new MutableLiveData<>();
}
