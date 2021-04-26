package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LauncherMode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActivityListTest.getInstance().addActivity(this);

//        Log.e(TAG, "Main onCreate   " + getIntent().getStringExtra("current"));
//        Log.e(TAG, ActivityListTest.getInstance().getActivities().toString());
//
////        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
////            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
////            @Override
////            public void onClick(View v) {
//////                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//////                intent.putExtra("current", System.currentTimeMillis()+"");
//////                startActivity(intent);
////
////                startActivity(new Intent(MainActivity.this, MainActivity2.class),
////                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
////            }
////        });
//
//        PackageManager pm = getPackageManager();
////        Log.e("PACKAGE_MANAGER",pm.getInstalledPackages(PackageManager.GET_ACTIVITIES).toString());
//
////        pm.getInstalledPackages(PackageManager.GET_ACTIVITIES);
//        try {
//
//            Log.e("Package_manager",  (pm.getPackageInfo("com.example.myapplication", PackageManager.GET_ACTIVITIES)==null)+" ");
//            Log.e("Package_manager",pm.getPackageInfo("com.example.myapplication",PackageManager.GET_ACTIVITIES).versionName.toString());
//        } catch (Exception e) {
//
//        }

    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "Main onStart  " + getIntent().getStringExtra("current"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "Main onResume   " + getIntent().getStringExtra("current"));

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "Main onRestart  " + getIntent().getStringExtra("current"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Log.e(TAG, "Main onNewIntent" + intent.getStringExtra("current"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityListTest.getInstance().removeActivities(this);
    }
}
