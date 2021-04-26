package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity5 extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        bottomNavigationView = findViewById(R.id.bottom);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.content);
        Log.e("Coller",(navHostFragment==null)+"");
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}

//    Fragment1  onAttach
//    Fragment1  onCreate
//    Fragment1  onCreateView
//    Fragment1  onStart
//    Fragment1  onResume
//    Fragment1  onPause
//    Fragment1  onStop
//    Fragment1  onDestroyView


//    Fragment1  onDestroy
//    Fragment1  onDetach
//    Fragment1  onAttach
//    Fragment1  onCreate
//    Fragment1  onCreateView
//    Fragment1  onStart
//    Fragment1  onResume