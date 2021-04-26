package com.example.nav.download;

import android.graphics.Bitmap;

import java.io.IOException;

public interface ImageCache {
    void put(String key, Bitmap value) throws IOException;

    Bitmap getBitmap(String key);
}
