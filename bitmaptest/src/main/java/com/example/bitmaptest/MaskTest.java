package com.example.bitmaptest;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MaskTest extends View {

    public MaskTest(Context context) {
        super(context);
    }

    public MaskTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        BlurMaskFilter blurMaskFilter=null;
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(68);
        paint.setStrokeWidth(5);

        blurMaskFilter=new BlurMaskFilter(10f,BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(blurMaskFilter);
        canvas.drawText("这是一段测试文字",100,100,paint);

        blurMaskFilter=new BlurMaskFilter(10f,BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(blurMaskFilter);
        canvas.drawText("这是一段测试文字",100,200,paint);

        blurMaskFilter=new BlurMaskFilter(10f,BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(blurMaskFilter);
        canvas.drawText("这是一段测试文字",100,300,paint);

        blurMaskFilter=new BlurMaskFilter(10f,BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(blurMaskFilter);
        canvas.drawText("这是一段测试文字",100,400,paint);

    }

}
