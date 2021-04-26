package com.example.nav;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.nav.download.DownloadImage;
import com.example.nav.download.MemoryCache;

import java.io.ByteArrayOutputStream;

public class Test2Activity extends AppCompatActivity {

    private ImageView imageView;

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        imageView = findViewById(R.id.img);

        Log.e("memory", Runtime.getRuntime().maxMemory() + "   " + Runtime.getRuntime().totalMemory());

//        int a=-15;
//        Log.e("-----",(a>>2)+" ");
//        Thread t=new Thread1();
//        t.start();


//        final FutureTask<Drawable> bitmapFutureTask = new FutureTask<>(new Callable<Drawable>() {
//            @Override
//            public Drawable call() throws Exception {
//                URL url = new URL("https://wanandroid.com/blogimgs/8a0131ac-05b7-4b6c-a8d0-f438678834ba.png");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setDoInput(true);
////                connection.connect();
//                final Drawable drawable = Drawable.createFromStream(connection.getInputStream(), "src");
//                Log.e("image ", (drawable == null) + "  " + connection.getResponseCode());
//                return drawable;
//            }
//        });
//
//
//        new Thread(bitmapFutureTask).start();
//
//        try {
//            imageView.setImageDrawable(bitmapFutureTask.get());
//        } catch (Exception e) {
//
//        }

//        https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png
//        try {
//            DownloadSomeThing.displayImg("https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png",imageView);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        DownloadImage downloadImage=new DownloadImage();
//        try{
//            downloadImage.setImageCache(new MemoryCache());
//            downloadImage.displayImg("https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png",imageView);
//
//        }catch (Exception e){
//            Log.e("-----",e.toString());
//        }

        String path = "https://wanandroid.com/blogimgs/04d6f53b-65e8-4eda-89c0-5981e8688576.png";
        DownloadImage.getDownloadImage().setImageCache(new MemoryCache()).displayImg(path, imageView);


    }


    class Thread1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("Thread -start");
            try {
                System.out.println("Thread -sleep");
                Thread.sleep(5000);

            } catch (Exception e) {

            }
            System.out.println("Thread -end");

        }
    }
}