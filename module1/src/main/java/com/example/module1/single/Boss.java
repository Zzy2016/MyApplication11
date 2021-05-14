package com.example.module1.single;

//第一次调用getInstance时进行初始化 懒汉式
//声明静态对象时初始化  饿汉式
public class Boss extends Staff {
    //饿汉式
    private static final Boss boss=new Boss();
    private Boss(){}

    public static Boss getBoss() {
        return boss;
    }

    //懒汉式
//    private static Boss boss;
//    private Boss(){}
//    public static synchronized Boss getBoss() {
//        if (boss == null) {
//            boss = new Boss();
//        }
//        return boss;
//    }


    //double check lock
//    private volatile static Boss boss;
//
//    public Boss() {
//    }
//
//    public static Boss getBoss() {
//        if (boss == null) {  //避免不必要的同步
//            synchronized (Boss.class) {
//                if (boss == null) {//在null的时候创建实例
//                    boss = new Boss();
//                }
//            }
//        }
//        return boss;
//    }


    //静态内部类单例模式



    @Override
    public void work() {
        super.work();
    }
}
