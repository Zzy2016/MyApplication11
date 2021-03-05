package com.example.nav;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private Map<Integer,Fragment> fragments;
    private List<String> titles;

    public CustomPagerAdapter(@NonNull FragmentManager fm, List<String> titles) {
        super(fm);
        this.fragments =new HashMap<>();
        this.titles = titles;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment == null) {
            fragment = new BlankFragment4();
            fragments.put(position,fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
