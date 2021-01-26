package com.example.myapplication11.ui.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication11.R;
import com.example.myapplication11.base.BaseActivity;
import com.example.myapplication11.config.Constants;
import com.example.myapplication11.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {


    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private boolean isLogin;


    @Override
    protected void handleIntent(Intent intent) {
//        super.handleIntent(intent);
        isLogin = intent.getBooleanExtra(Constants.ParamCode.PARAM1, false);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        isLogin = intent.getBooleanExtra(Constants.ParamCode.PARAM1, false);
    }

    public static void start(Context context, Boolean isLogin) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.ParamCode.PARAM1, isLogin);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void bindViewModel() {

    }

    @Override
    protected void init() {
        initView();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void login(){

    }

    private void initView(){
        drawer=mDataBinding.drawerLayout;
        mAppBarConfiguration=new AppBarConfiguration.Builder(R.id.navHome,R.id.navSquare).setDrawerLayout(drawer).build();

        NavController navController= Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupActionBarWithNavController(this,navController,mAppBarConfiguration);
        NavigationUI.setupWithNavController(mDataBinding.navView,navController);

        BottomNavigationView navView=findViewById(R.id.navViewBottom);
        NavigationUI.setupWithNavController(navView,navController);
    }

    private void initUserData(){

    }

    private void initFloatingActionButton(){

    }

//    private Fragment getFragment(){
//        Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
//        Fragment fragment1=fragment.getChildFragmentManager().getPrimaryNavigationFragment();
//        if(fragment1 instanceof )
//    }

}