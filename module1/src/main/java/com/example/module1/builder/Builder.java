package com.example.module1.builder;

public abstract class Builder {
    //设置主机
    public abstract Builder buildBoard(String board);

    //设置显示器
    public abstract Builder buildDisplay(String display);

    //设置操作系统
    public abstract Builder buildOS();

    //创建Computer
    public abstract Computer create();
}
