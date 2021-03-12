package com.example.appkotlin.bean;

import androidx.work.Data;

import java.io.Serializable;
import java.util.List;

@lombok.Data
public class BannerModel implements Serializable {

    /**
     * data : [{"desc":"扔物线","id":29,"imagePath":"https://wanandroid.com/blogimgs/8a0131ac-05b7-4b6c-a8d0-f438678834ba.png","isVisible":1,"order":0,"title":"声明式 UI？Android 官方怒推的 Jetpack Compose 到底是什么？","type":0,"url":"http://i0k.cn/4WyJG"},{"desc":"","id":6,"imagePath":"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png","isVisible":1,"order":1,"title":"我们新增了一个常用导航Tab~","type":1,"url":"https://www.wanandroid.com/navi"},{"desc":"一起来做个App吧","id":10,"imagePath":"https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png","isVisible":1,"order":1,"title":"一起来做个App吧","type":1,"url":"https://www.wanandroid.com/blog/show/2"},{"desc":"","id":20,"imagePath":"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png","isVisible":1,"order":2,"title":"flutter 中文社区 ","type":1,"url":"https://flutter.cn/"}]
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private List<DataBean> data;

    @lombok.Data
    public static class DataBean implements Serializable {
        /**
         * desc : 扔物线
         * id : 29
         * imagePath : https://wanandroid.com/blogimgs/8a0131ac-05b7-4b6c-a8d0-f438678834ba.png
         * isVisible : 1
         * order : 0
         * title : 声明式 UI？Android 官方怒推的 Jetpack Compose 到底是什么？
         * type : 0
         * url : http://i0k.cn/4WyJG
         */

        private String desc;
        private int id;
        private String imagePath;
        private int isVisible;
        private int order;
        private String title;
        private int type;
        private String url;
    }
}
