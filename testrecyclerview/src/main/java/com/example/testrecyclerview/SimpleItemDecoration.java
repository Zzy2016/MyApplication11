package com.example.testrecyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/*
* recyclerview ItemDecoration
* getItemOffsets  类似padding
* onDraw  类似背景
* onDrawOver 绘制在内容上 覆盖内容
* */
public class SimpleItemDecoration extends RecyclerView.ItemDecoration {

    private int dividerHeight;
    private Paint paint1;
    private Paint paint2;
    private Paint paintText;

    public SimpleItemDecoration(int dividerHeight) {
        this.dividerHeight = dividerHeight;
        paint1 = new Paint();
        paint1.setColor(Color.parseColor("#10910a"));
        paint2 = new Paint();
        paint2.setColor(Color.parseColor("#248cfa"));
        paintText=new Paint();
        paintText.setTextSize(26);
        paintText.setColor(Color.WHITE);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = dividerHeight;// 效果类似padding
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //修改颜色
//        int left = parent.getPaddingLeft();
//        int right = parent.getWidth() - parent.getPaddingRight();
//        for (int i = 0; i < parent.getChildCount() - 1; i++) {
//            View view = parent.getChildAt(i);
//            float top = view.getBottom();
//            float bottom = top + dividerHeight;
//            //在view下绘制一个rect
//            c.drawRect(left, top, right, bottom, paint);
//        }

    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        for(int i=0;i<parent.getChildCount()-1;i++){
            View view=parent.getChildAt(i);
            int position=parent.getChildAdapterPosition(view);
            if(position%2==0){
                float left=view.getPaddingLeft();
                float right=left+30;
                float top=view.getTop();
                float bottom=view.getBottom();
                c.drawRect(left,top,right,bottom,paint1);
                c.drawText(i+"",left+10,(bottom-top)/2+(i*(view.getHeight()+dividerHeight)),paintText);
            }else{
                float right=view.getRight()-view.getPaddingRight();
                float left=right-30;
                float top=view.getTop();
                float bottom=view.getBottom();
                c.drawRect(left,top,right,bottom,paint2);
                c.drawText("测试",left+10,(bottom-top)/2+(i*(view.getHeight()+dividerHeight)),paintText);
            }
        }
    }
}
