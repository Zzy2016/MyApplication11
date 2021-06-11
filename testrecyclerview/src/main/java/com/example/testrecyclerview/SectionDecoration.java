package com.example.testrecyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SectionDecoration extends RecyclerView.ItemDecoration {

    private List<String> list;

    private List<Integer> nodeList;

    private TextPaint textPaint;
    private Paint paint;
    private int topGap;
    private Paint.FontMetrics fontMetrics;


    public SectionDecoration(List<String> list) {
        this.list = list;
        nodeList = new ArrayList<>();
        searchNode();
        paint = new Paint();
        paint.setColor(Color.GREEN);

        textPaint = new TextPaint();
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(80);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.getFontMetrics(fontMetrics);
        fontMetrics = new Paint.FontMetrics();
        topGap = 100;
    }

    public void searchNode() {
        nodeList.add(0);
        for (int i = 0; i < list.size() - 2; i++) {
            String curr = list.get(i).substring(0, 1);
            String next = list.get(i + 1).substring(0, 1);
            if (!curr.equals(next)) {
                nodeList.add(i + 1);
            }
        }
    }


    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);


        int itemCount = state.getItemCount();  //13
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        float lineHeight = textPaint.getTextSize() + fontMetrics.descent;
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
//            if (!isFirst(position)) {
//                continue;
//            }
            String text = list.get(position).substring(0, 1);
            int viewBottom = view.getBottom();
            float textY = Math.max(topGap, view.getTop());
            Log.e("drawOver", "textY " + textY);
//            if (!text.equals(list.get(position + 1).substring(0, 1))) {
//                if (viewBottom < textY) {
//                    textY = viewBottom;
//                }
//            }


            View firstView = parent.getChildAt(0);
            if (!list.get(parent.getChildAdapterPosition(firstView)).substring(0, 1).equals(list.get(parent.getChildAdapterPosition(firstView)+1).substring(0, 1))) {
                textY = viewBottom;
            }
            c.drawRect(left, textY - topGap, right, textY, paint);
            c.drawText(text, left, textY, textPaint);

        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
//        int left = parent.getPaddingLeft();
//        int right = parent.getWidth() - parent.getPaddingRight();
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount - 1; i++) {
//            View view = parent.getChildAt(i);
//            int position = parent.getChildAdapterPosition(view);
//            String text = list.get(position).substring(0, 1);
//
//            if (isFirst(position)) {
//                float top = view.getTop() - topGap;
//                float bottom = view.getTop();
//                c.drawRect(left, top, right, bottom, paint);
//                c.drawText(text, left, (bottom - 20), textPaint);
//            }
//        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (isFirst(position)) {
            outRect.top = topGap;
        }
    }

    public boolean isFirst(int position) {
        return nodeList.indexOf(position) != -1;
    }

}
