package com.example.module1.proxytest;


import java.lang.reflect.Proxy;

//
//
public class Client {
    public static void main(String[] args) {
//        RealSubject realSubject = new RealSubject();
//        ProxySubject proxySubject = new ProxySubject(realSubject);
//        proxySubject.visit();
//
//        Xiaoming xiaoming=new Xiaoming();
//        Lawyer lawyer=new Lawyer(xiaoming);
//        lawyer.burden();


        ILawsuit xiaoming = new Xiaoming();

        DynamicProxy proxy = new DynamicProxy(xiaoming);
        ClassLoader loader = xiaoming.getClass().getClassLoader();
//        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, proxy);
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader, Xiaoming.class.getInterfaces(), proxy);
        lawyer.burden();

    }
}
