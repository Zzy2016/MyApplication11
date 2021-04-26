package com.example.nav;

import android.graphics.Bitmap;
import android.util.LruCache;

import java.util.BitSet;

public class ImageCache {
    private LruCache<String, Bitmap> lruCache;

    public ImageCache() {
        initImageCache();
    }

    public void initImageCache() {
        //最大内存
        int total = (int) Runtime.getRuntime().maxMemory() / 1024;


        //可用
        int cache = total / 8;

        lruCache = new LruCache<String, Bitmap>(cache) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void put(String key, Bitmap value) {
        lruCache.put(key, value);
    }

    public Bitmap get(String key) {
        return lruCache.get(key);
    }

}
