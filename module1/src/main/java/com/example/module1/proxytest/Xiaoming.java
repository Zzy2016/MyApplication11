package com.example.module1.proxytest;

public class Xiaoming implements ILawsuit {
    @Override
    public void submit() {
        System.out.println("--->  submit");
    }

    @Override
    public void burden() {
        System.out.println("--->  burden");
    }

    @Override
    public void defend() {
        System.out.println("--->  defend");
    }

    @Override
    public void finish() {
        System.out.println("--->  finish");
    }
}
