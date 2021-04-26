package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.page.BlankFragment1;
import com.example.myapplication.page.BlankFragment2;
import com.example.myapplication.page.BlankFragment3;
import com.example.myapplication.page.BlankFragment4;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {


    private RadioGroup rg;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BlankFragment1 fragment1;
    private BlankFragment2 fragment2;
    private BlankFragment3 fragment3;
    private BlankFragment4 fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        fragment1 = new BlankFragment1();
        fragment2 = new BlankFragment2();
        fragment3 = new BlankFragment3();
        fragment4 = new BlankFragment4();


        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fl, fragment1).commit();
        fragmentTransaction
                .add(R.id.fl, fragment1)
                .add(R.id.fl, fragment2).hide(fragment2)
                .add(R.id.fl, fragment3).hide(fragment3)
                .add(R.id.fl, fragment4).hide(fragment4)
                .show(fragment1)
                .commit();


        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.rb1:
                        fragmentTransaction.show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4);
                        break;
                    case R.id.rb2:
                        fragmentTransaction.hide(fragment1).show(fragment2).hide(fragment3).hide(fragment4);
                        break;
                    case R.id.rb3:
                        fragmentTransaction.hide(fragment1).hide(fragment2).show(fragment3).hide(fragment4);
                        break;
                    case R.id.rb4:
                        fragmentTransaction.hide(fragment1).hide(fragment2).hide(fragment3).show(fragment4);
                        break;
                }
                fragmentTransaction.commit();

//                switch (checkedId) {
//                    case R.id.rb1:
//                        fragmentTransaction.replace(R.id.fl, new BlankFragment1());
//                        break;
//                    case R.id.rb2:
//                        fragmentTransaction.replace(R.id.fl, new BlankFragment2());
//                        break;
//                    case R.id.rb3:
//                        fragmentTransaction.replace(R.id.fl, new BlankFragment3());
//                        break;
//                    case R.id.rb4:
//                        fragmentTransaction.replace(R.id.fl, new BlankFragment4());
//                        break;
//                }
//                fragmentTransaction.commit();
            }
        });

    }

}



//    public void getAllPackages() {
//
//        List<PackageInfo> packageInfoList = pm.getInstalledPackages(PackageManager.GET_ACTIVITIES);
//
//        for (PackageInfo pi : packageInfoList) {
//            Log.e("Package-allpack", pi.packageName);
//        }
//    }
//
//    public void ifInstalled(String packageName) {
//        try {
//            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
//            if (packageInfo == null) {
//
//            } else {
//
//            }
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    public void getPackageInfoByPackage(String packageName) {
//        try {
//            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
//
//        } catch (Exception e) {
//
//        }
//    }
//
//    public void getAppName(String packageName) {
//        try {
//            PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
//            Log.e("Package-appName", packageInfo.applicationInfo.loadLabel(pm).toString());
//            Log.e("Package-appName", packageInfo.applicationInfo.loadIcon(pm).toString());
//        } catch (Exception e) {
//
//        }
//    }
//
//
//    public void getPackageInfoByApk(String apkPath) {
//        try {
//            PackageInfo packageInfo = pm.getPackageArchiveInfo(apkPath, PackageManager.GET_ACTIVITIES);
//        } catch (Exception e) {
//
//        }
//    }

    /*

    onAttach
    * onCreate
    * onStart
    * onResume
    * onPause
    * onStop
    * onDestroy
    * onDetach
    *
    * */

/*FragmentManager  相应用户交互、添加、删除、替换等操作
 * getSupportFragmentManager
 * getChildFragmentManager
 * getParentFragmentManager
 *
 * FragmentTransaction
 * 允许重新排列片段状态更改 setReorderingAllowed
 * 添加和删除片段  add remove
 *     提交时异步  commit()  commitNow()
 * 显示和隐藏片段 show hide
 *
 * setReorderingAllowed
 *
 *
 *  */