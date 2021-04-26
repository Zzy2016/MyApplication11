package com.example.nav.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DownloadImage {

    private static DownloadImage downloadImage;
    private static ExecutorService executorService;

    public static DownloadImage getDownloadImage() {
        if (downloadImage == null) {
            synchronized (DownloadImage.class) {
                if (downloadImage == null) {
                    downloadImage = new DownloadImage();
                    executorService =Executors.newFixedThreadPool(4);
                }
            }
        }
        return downloadImage;
    }


    private ImageCache imageCache;

    public DownloadImage setImageCache(ImageCache imageCache) {
        this.imageCache = imageCache;
        return downloadImage;
    }

    public void displayImg(final String url, final ImageView imageView) {

        Bitmap bitmap = imageCache.getBitmap(url);

        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        try {
            imageView.setImageBitmap(executorService.submit(new Callable<Bitmap>() {
                @Override
                public Bitmap call() throws Exception {
                    return downloadImg(url);
                }
            }).get());
        } catch (Exception e) {

        }
    }

    private Bitmap downloadImg(String url) {

        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(new URL(url).openStream());
            if (bitmap != null) {
                imageCache.put(url, bitmap);
            }
        } catch (Exception e) {

        }
        return bitmap;
    }


//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
////        threadPoolExecutor.execute(new Runnable() {
////            @Override
////            public void run() {
////
////            }
////        });
//        ExecutorService threadPoolExecutor1= (ThreadPoolExecutor) Executors.newWorkStealingPool();
//
//
//        threadPoolExecutor
//    }


//    newCachedThreadPool()
//    newFixedThreadPool(int nThread) 固定线程数
//    newSingleThreadExecutor()

//    newScheduledThread(int )  指定线程数的线程池
//    newSingleThreadScheduleExecutor()  只有一个线程

//    ExecutorService newWorkStealingPool(int) 足够的线程池
//    ExecutorService newWorkStealingPool()  //创建cpu数相同线程


}
