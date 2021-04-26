package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.page.BlankFragment1;
import com.example.myapplication.page.BlankFragment2;
import com.example.myapplication.page.BlankFragment3;
import com.example.myapplication.page.BlankFragment4;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {


    RadioGroup rg;
    RadioButton rb1, rb2, rb3, rb4;
    ArrayList<Fragment> fragments;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        vp=findViewById(R.id.vp);
        rg=findViewById(R.id.rg);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);

        fragments=new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());

        Adapter1 adapter1=new Adapter1(getSupportFragmentManager(),fragments);
        vp.setAdapter(adapter1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        vp.setCurrentItem(0,false);
                        fragments.get(1).onResume();
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1,false);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2,false);
                        break;
                    case R.id.rb4:
                        vp.setCurrentItem(3,false);
                        break;
                }
            }
        });
    }
}