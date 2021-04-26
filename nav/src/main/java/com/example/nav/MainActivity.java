package com.example.nav;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.nav.download.DownloadImage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadImage.getDownloadImage().displayImg("",null);


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav);
        final NavController navController = navHostFragment.getNavController();

//        NavController navController = Navigation.findNavController(this, R.id.nav);
        BottomNavigationView bottomView = findViewById(R.id.bottom);
        NavigationUI.setupWithNavController(bottomView, navController);
        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.item1:
                        navController.navigate(R.id.homeFragment);
                        break;
                    case R.id.item2:
                        navController.navigate(R.id.blankFragment);
                        break;
                    case R.id.item3:
                        navController.navigate(R.id.blankFragment2);
                        break;
                    case R.id.item4:
                        navController.navigate(R.id.blankFragment3);
                        break;

                }
                return true;
            }
        });




//        DownloadImage.getDownloadImage().displayImg();
    }
}
