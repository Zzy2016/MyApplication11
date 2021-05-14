package com.example.module1.builder;

public class MacBookBuilder extends Builder {
    private Computer mComputer = new Macbook();

//    @Override
//    public void buildBoard(String board) {
//        mComputer.setBoard(board);
//    }
//
//    @Override
//    public void buildDisplay(String display) {
//        mComputer.setDisplay(display);
//    }
//
//    @Override
//    public void buildOS() {
//        mComputer.setOs();
//    }

    @Override
    public Builder buildBoard(String board) {
        mComputer.setBoard(board);
        return this;
    }

    @Override
    public Builder buildDisplay(String display) {
        mComputer.setDisplay(display);
        return this;
    }

    @Override
    public Builder buildOS() {
        return this;
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
