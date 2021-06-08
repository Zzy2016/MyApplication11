package com.example.myapplication11.ui.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication11.base.BasePagerAdapter;
import com.example.myapplication11.bean.responsebean.WeChatBean;
import com.example.myapplication11.ui.articlelist.ArticleListFragment;

public class ArticleListPagerAdapter extends BasePagerAdapter<WeChatBean> {
    public ArticleListPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = mFragmentMap.get(position);
        if (fragment == null) {
            WeChatBean chatBean = mDataList.get(position);
            fragment = ArticleListFragment.newInstance(0, chatBean.getId());
            mFragmentMap.put(position, fragment);
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        WeChatBean chapter = mDataList.get(position);
        return chapter.getName();
    }



}
