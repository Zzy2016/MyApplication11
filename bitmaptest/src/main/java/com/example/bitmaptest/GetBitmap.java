package com.example.bitmaptest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class GetBitmap {

    private Map<String, SoftReference<Bitmap>> imageMap = new HashMap<>();

    public Bitmap loadBitmap(final String imageUrl, final ImageCallBack imageCallBack) {
        SoftReference<Bitmap> reference = imageMap.get(imageUrl);
        if (reference != null) {
            if (reference.get() != null) {
                return reference.get();
            }
        }
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Bitmap bitmap = (Bitmap) msg.obj;
                imageMap.put(imageUrl, new SoftReference<Bitmap>(bitmap));
                if (imageCallBack != null) {
                    imageCallBack.getBitmap(bitmap);
                }
            }
        };
        new Thread() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                message.obj = downloadBitmap(imageUrl);
                handler.sendMessage(message);
            }
        }.start();
        return null;
    }

    private Bitmap downloadBitmap(String imageUrl) {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(new URL(imageUrl).openStream());
            return bitmap;
        } catch (Exception e) {
            return null;
        }
    }


    public interface ImageCallBack {
        void getBitmap(Bitmap bitmap);
    }

}
