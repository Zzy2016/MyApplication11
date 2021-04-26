package com.example.nav;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.WindowManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class DiskCache {

    private String path = "";


    //写入sdcard
    public void put(String key, Bitmap bitmap) {
        File file = new File(path + key);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {

        }
    }

    public Bitmap getBitmap(String key) {
        return BitmapFactory.decodeFile(path + key);
    }

}
