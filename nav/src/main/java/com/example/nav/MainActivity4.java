package com.example.nav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nav.databinding.ActivityMain4Binding;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private List<String> images;
    private List<ImageBean> imageBeans = new ArrayList<>();
    private BannerData bannerData = new BannerData();
    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main4);

        ImageBean imageBean1 = new ImageBean();
        imageBean1.setPath("https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png");
        ImageBean imageBean2 = new ImageBean();
        imageBean2.setPath("https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png");
        ImageBean imageBean3 = new ImageBean();
        imageBean3.setPath("https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png");
        ImageBean imageBean4 = new ImageBean();
        imageBean4.setPath("https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png");

        imageBeans.add(imageBean1);
        imageBeans.add(imageBean2);
        imageBeans.add(imageBean3);
        imageBeans.add(imageBean4);

        bannerData.setList(imageBeans);
        binding.setBannerData(bannerData);

    }




    public static class BannerViewHolder implements MZViewHolder<ImageBean> {

        public ImageView imageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_img, null);
            imageView = view.findViewById(R.id.img);
            return view;
        }


        @Override
        public void onBind(Context context, int i, ImageBean imageBean) {
            Glide.with(context).load(imageBean.getPath()).into(imageView);
        }
    }

    /*
    * //开始轮播
     start()
    //停止轮播
     pause()

    //设置BannerView 的切换时间间隔
     setDelayedTime(int delayedTime)
    // 设置页面改变监听器
    addPageChangeLisnter(ViewPager.OnPageChangeListener onPageChangeListener)

    //添加Page点击事件
     setBannerPageClickListener(BannerPageClickListener bannerPageClickListener)
    //设置是否显示Indicator
    setIndicatorVisible(boolean visible)
    // 获取ViewPager
    ViewPager getViewPager()
    // 设置 Indicator资源
    setIndicatorRes(int unSelectRes,int selectRes)
    //设置页面数据
    setPages(List<T> datas,MZHolderCreator mzHolderCreator)
    //设置指示器显示位置
    setIndicatorAlign(IndicatorAlign indicatorAlign)
    //设置ViewPager（Banner）切换速度
    setDuration(int duration)
    *
    * */
}