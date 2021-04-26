package com.example.nav;

import java.util.List;

public class BannerData {
    private List<ImageBean> list;

    public List<ImageBean> getList() {
        return list;
    }

    public void setList(List<ImageBean> list) {
        this.list = list;
    }
}

//  应用
//  adb shell pm list packages [-f] [-d] [-e] [-s] [-3] [-i] [-u] [--user USER_ID] [FILTER]
//安装
//  adb install [-lrtsdg] <path_to_apk>
//卸载
//  adb uninstall [-k] <packagename>
//清除应用和缓存
//  adb shell pm clear <packagename>
//查看前台Activity
//  adb shell dumpsys activity activities |grep mFocusedActivity
//正在运行的Service
//  adb shell dumpsys activity services [packagename]
//a