package com.example.module1.builder;

//计算机抽象类 Product
public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    public Computer() {
    }

    public void setBoard(String mBoard) {
        this.mBoard = mBoard;
    }

    public void setDisplay(String mDisplay) {
        this.mDisplay = mDisplay;
    }

    public void setOs() {
        this.mOs = mOs;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
