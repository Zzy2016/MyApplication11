package com.example.nav;

import android.graphics.Bitmap;

public class DoubleCache {
    ImageCache imageCache = new ImageCache();
    DiskCache diskCache = new DiskCache();

    public Bitmap getBitmap(String key) {
        Bitmap bitmap = imageCache.get(key);
        if (bitmap == null) {
            bitmap = diskCache.getBitmap(key);
        }
        return bitmap;
    }

    public void put(String key, Bitmap value) {
        imageCache.put(key, value);
        diskCache.put(key, value);
    }
}
