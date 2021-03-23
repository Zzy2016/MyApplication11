package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        pm = getPackageManager();
        getAppName("com.example.myapplication");
        Log.e("Version",Build.VERSION.SDK_INT+"  ");

    }


    public void getAllPackages() {

        List<PackageInfo> packageInfoList = pm.getInstalledPackages(PackageManager.GET_ACTIVITIES);

        for (PackageInfo pi : packageInfoList) {
            Log.e("Package-allpack", pi.packageName);
        }
    }

    public void ifInstalled(String packageName) {
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            if (packageInfo == null) {

            } else {

            }

        } catch (Exception e) {

        }
    }

    public void getPackageInfoByPackage(String packageName) {
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);

        } catch (Exception e) {

        }
    }

    public void getAppName(String packageName) {
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            Log.e("Package-appName", packageInfo.applicationInfo.loadLabel(pm).toString());
            Log.e("Package-appName", packageInfo.applicationInfo.loadIcon(pm).toString());
        } catch (Exception e) {

        }
    }


    public void getPackageInfoByApk(String apkPath) {
        try {
            PackageInfo packageInfo = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
        } catch (Exception e) {

        }
    }
}