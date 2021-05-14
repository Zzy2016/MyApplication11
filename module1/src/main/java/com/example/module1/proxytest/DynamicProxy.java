package com.example.module1.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//动态代理
//invoke 调用具体的被代理方法
public class DynamicProxy implements InvocationHandler {

    private Object obj;//被代理的类引用

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method  --"+method.getName());
        Object result = method.invoke(obj, args);
        return result;
    }
}
