package com.example.httptestj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;
import static com.bumptech.glide.request.RequestOptions.option;
import static com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf;

public class MainActivity7 extends AppCompatActivity {

    String url = "https://huiyi-pro.oss-cn-hangzhou.aliyuncs.com/100062/doctor/154699769300078.jpg?Expires=1614222809&OSSAccessKeyId=TMP.3KdgxZuUjEF5vTdU6wRgwxHBLak24adPCJ7hoQvoKmrWYafVXZ1TWY8S1VRZ8DVQ54svBq2HnucctDzWdNypUdjLLjdisd&Signature=F44W59XXpsxl%2B8N6DV9tvCire%2FU%3D";
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        image = findViewById(R.id.image);

//        Glide.with(this).load(R.drawable.ic_launcher_background).into(image);
//        Glide.with(this).load(url).apply().into(image);

//        RequestOptions options = RequestOptions.circleCropTransform();
//        Glide.with(this).load(url).apply(options).into(image);

//        Glide.with(this).load(url).apply(bitmapTransform(new Glide(25,3)))
//                .into(image);


        loadImage();

    }

    public void loadImage() {
//        String url="http://guolin.tech/book.png";
//        Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(image);

//        RequestOptions options=new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground);
//        Glide.with(this).load(url).apply(options).into(image);

        //淡入淡出动画  transition(withCrooFade())
//        Glide.with(this).load(url).transition(withCrossFade()).into(image);

        //图片大小减小剪裁
//        RequestOptions requestOptions=new RequestOptions().override(100,100);
//        Glide.with(this).load(url).apply(requestOptions).into(image);


        //圆形图片
        //RequestOptions options=new RequestOptions().circleCrop();
        //Glide.with(this).load(url).into(image);

        //缩略图
//        Glide.with(this).load(url).thumbnail(0.25f).into(image);

//        缓存设置  内存缓存  硬盘缓存
        //内存缓存防止应用重复将图片读取到内存当中
        //硬盘缓存防止应用重复从网络或者其他地方重复下载和读取数据
//            skipMemoryCache  true 关闭内存缓存 false打开内存缓存
//        diskCacheStrategy  DiskCacheStrategy.NONE 关闭磁盘缓存
//        DiskCacheStrategy.NONE 不缓存任何内容
//        DiskCacheStrategy.Date 只缓存原始图片
//        DiskCacheStrategy.RESOURCE 只缓存转换过后的图片
//        DiskCacheStrategy.ALL 即缓存原始图片，也缓存转换过后的图片
//        DiskCacheStrategy.AUTOMATIC  让Glide根据图片资源智能地选择使用哪一种缓存策略


        //清空缓存
//        Glide.get(this).clearMemory();//清空内存缓存，要求在主线程中执行
//        Glide.get(this).clearDiskCache();//清空磁盘缓存，要求在后台线程中执行

        //指定加载格式 glide 4 指定加载格式load
//        Glide.with(this).asBitmap().load("http://guolin.tech/test.gif").into(image);

        //回调和监听
//        into()   preload   submit listener

//        SimpleTarget<Drawable> simpleTarget = new SimpleTarget<Drawable>() {
//            @Override
//            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
//                image.setImageDrawable(resource);
//            }
//        };
//
//        Glide.with(this).load(url).into(simpleTarget);




    }
}