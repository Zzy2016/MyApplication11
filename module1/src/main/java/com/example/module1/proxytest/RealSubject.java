package com.example.module1.proxytest;

//
public class RealSubject extends Subject {
    @Override
    public void visit() {
        System.out.println("Real subject");
    }
}
