package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.testrecyclerview.databinding.ActivityHeadAndFooterBinding;

public class HeadAndFooterActivity extends AppCompatActivity {


    ActivityHeadAndFooterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_head_and_footer);
//
        binding = DataBindingUtil.setContentView(this, R.layout.activity_head_and_footer);

        binding.rv.setAdapter(new HeadAndFootAdapter(this));
//        binding.rv.setLayoutManager(new GridLayoutManager(this,2));


//        GridLayoutManager manager = new GridLayoutManager(this, 3);
//        binding.rv.setLayoutManager(manager);
//
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return position==0 ? manager.getSpanCount() : 1;
//            }
//        });

        binding.rv.addOnItemTouchListener(new RecyclerViewClickListener(this, binding.rv, new RecyclerViewClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }

}