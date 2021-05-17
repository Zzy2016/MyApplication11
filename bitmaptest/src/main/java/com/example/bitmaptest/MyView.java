package com.example.bitmaptest;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;


//Canvas
//Paint
//Path
public class MyView extends View {

    private Paint paint;
    private WindowManager windowManager;
    private int allWidth = 0;


    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.black));
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(36);
        paint.setStrokeWidth(5);
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        allWidth = windowManager.getDefaultDisplay().getWidth();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.teal_700));
//        canvas.drawCircle(100,200,100,paint);
//        canvas.drawRect(300,300,500,500,paint);
//        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.test),600,600,paint);

//        canvas.drawRect(0,0,600,600,paint);
//        paint.setColor(getResources().getColor(R.color.design_default_color_error));
//        canvas.drawRect(0,0,600,600,paint);
//        paint.setColor(getResources().getColor(R.color.purple_200));
//        canvas.drawArc(new RectF(0,0,600,600),0,270,false,paint);

//        canvas.drawArc(600,600,900,900,0,90,false,paint);


//        Path path=new Path();
//        path.arcTo(0,0,600,600,0,270,true);
//        path.moveTo(500,500);
//        path.lineTo(100,100);
//        path.lineTo(300,300);
//        canvas.drawPath(path,paint);
//        path.quadTo(100,100,400,400);
//        canvas.drawPath(path,paint);

//        canvas.drawTextOnPath("测试绘制",path,50,50,paint);
//        canvas.drawDo

//        canvas.translate(canvas.getWidth()/2, 200); //将位置移动画纸的坐标点:150,150
//        canvas.drawCircle(0, 0, 100, paint); //画圆圈
//
//        //使用path绘制路径文字
//        canvas.save();
//        canvas.translate(-75, -75);
//        Path path = new Path();
//        path.addArc(new RectF(0,0,150,150), -180, 180);
//        Paint citePaint = new Paint(paint);
//        citePaint.setTextSize(14);
//        citePaint.setStrokeWidth(1);
//        canvas.drawTextOnPath("绘制表盘~", path, 28, 0, citePaint);
//        canvas.restore();
//
//        Paint tmpPaint = new Paint(paint); //小刻度画笔对象
//        tmpPaint.setStrokeWidth(1);
//
//        float  y=100;
//        int count = 60; //总刻度数
//
//        for(int i=0 ; i <count ; i++){
//            if(i%5 == 0){
//                canvas.drawLine(0f, y, 0, y+12f, paint);
//                canvas.drawText(String.valueOf(i/5+1), -4f, y+25f, tmpPaint);
//                Log.e("path",ca);
//            }else{
//                canvas.drawLine(0f, y, 0f, y +5f, tmpPaint);
//            }
//
//            canvas.rotate(360/count,0f,0f); //旋转画纸
//        }
//
//        //绘制指针
//        tmpPaint.setColor(Color.GRAY);
//        tmpPaint.setStrokeWidth(4);
//        canvas.drawCircle(0, 0, 7, tmpPaint);
//        tmpPaint.setStyle(Paint.Style.FILL);
//        tmpPaint.setColor(Color.YELLOW);
//        canvas.drawCircle(0, 0, 5, tmpPaint);
//        canvas.drawLine(0, 10, 0, -65, paint);


//        Paint paint = new Paint();
//        paint.setColor(Color.parseColor("#ffffff"));
//        paint.setAntiAlias(true);
//        paint.setStrokeWidth(4);
//        paint.setStyle(Paint.Style.STROKE);
////        canvas.drawArc(allWidth / 4, allWidth / 4, allWidth / 2 + allWidth / 4, allWidth / 2 + allWidth / 4, 0, 360, true, paint);
        int startX=allWidth/4;
        int startY=allWidth/4;
        int stopX=allWidth/4;
        int stopY=allWidth/4+4;
//
//
//        int y=100;
        canvas.translate(allWidth/2,allWidth/2);
        for (int i = 0; i < 60; i++) {
            canvas.drawLine(startX,startY,stopX,stopY,paint);
            canvas.drawText(String.valueOf(i),startX,startY,paint);
            canvas.rotate(360/60, 0f, 0f); //旋转画纸
        }




    }


}
