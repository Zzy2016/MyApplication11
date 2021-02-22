package com.example.nav1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BannerTestActivity extends AppCompatActivity {

    MZBannerView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_test);

        banner = findViewById(R.id.banner);

        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(BannerTestActivity.this, "click page:" + position, Toast.LENGTH_LONG).show();
            }
        });


        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.ico_account);
        list.add(R.mipmap.ico_ali);
        list.add(R.mipmap.ico_colled);
        list.add(R.mipmap.ico_we);

        banner.setPages(list, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        banner.start();

        banner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Log.e("banner",position+"      --------");
            }
        });

//        banner.setDelayedTime(500)

    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.pause();
    }

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.item, null);
            imageView = view.findViewById(R.id.imgItem);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
}