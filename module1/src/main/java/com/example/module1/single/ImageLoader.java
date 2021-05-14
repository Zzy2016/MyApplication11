package com.example.module1.single;

public class ImageLoader {
    private static ImageLoader imageLoader;

    private ImageLoader() {
    }

    public static ImageLoader getImageLoader() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader();
        }
        return imageLoader;
    }

    public void downImage(){

    }

}
