package com.example.testrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.VERTICAL;

public class GridActivity extends AppCompatActivity {


    RecyclerView rv;
    int allWidth = 0;
    int divide = 0;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        allWidth = getDisplay().getWidth();
        divide = allWidth / 4 / 5;

        rv = findViewById(R.id.rv);
        rv.setAdapter(new CommImgAdapter(this));
        rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

//        rv.setLayoutManager(new GridLayoutManager(this, 3));
//        rv.addItemDecoration(new SpacesItemDecoration());
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int space = 30;
            outRect.top = 10;


            if (parent.getChildAdapterPosition(view) % 3 == 0) {
                outRect.left = space;
            } else if (parent.getChildAdapterPosition(view) % 3 == 1) {
                outRect.left = space/2;
                outRect.right = space/2;
            } else if (parent.getChildAdapterPosition(view) % 3 == 2) {
                outRect.right = space;
            }
//            outRect.right = space;
        }


    }

}