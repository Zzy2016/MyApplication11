package com.example.nav.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

public class DoubleCache implements ImageCache {
    private MemoryCache memoryCache;
    private DiskCache diskCache;

    public DoubleCache() {
        memoryCache = new MemoryCache();
        diskCache = new DiskCache();
    }

    @Override
    public void put(String key, Bitmap value) throws IOException {
        memoryCache.put(key, value);
        diskCache.put(key, value);
    }

    @Override
    public Bitmap getBitmap(String key) {
        Bitmap bitmap = memoryCache.getBitmap(key);
        if (bitmap == null) {
            bitmap = diskCache.getBitmap(key);
        }
        return bitmap;
    }
}
