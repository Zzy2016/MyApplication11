package com.example.nav.download;

import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryCache implements ImageCache {

    private LruCache<String, Bitmap> lruCache = null;

    public MemoryCache() {
        int maxLength = (int) Runtime.getRuntime().maxMemory() / 1024;
        lruCache = new LruCache<String, Bitmap>(maxLength / 4) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public void put(String key, Bitmap value) {
        lruCache.put(key, value);
    }

    @Override
    public Bitmap getBitmap(String key) {
        return lruCache.get(key);
    }
}
