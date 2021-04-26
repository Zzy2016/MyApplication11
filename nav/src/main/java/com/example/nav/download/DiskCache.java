package com.example.nav.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class DiskCache implements ImageCache {

    private String rootPath = "";

    public DiskCache() {
    }


    @Override
    public void put(String key, Bitmap value) throws IOException {
        //
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(rootPath + key);
            value.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } catch (IOException e) {

        } finally {
            fileOutputStream.close();
        }

    }

    @Override
    public Bitmap getBitmap(String key) {
        return BitmapFactory.decodeFile(rootPath+key);
    }
}
