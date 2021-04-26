package com.example.nav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("ceshi " + i);
            list1.add(i);
        }
        printArray(list);
        printArray(list1);
        Log.e("test1", test1(list));
        Log.e("test", test1(list1) + "");


    }


    //泛型方法，
    //类型参数声明部分 该类型参数声明部分在返回值类型前
    //类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）
    public <T> void printArray(List<T> list) {
        for (T t : list) {
            Log.e("测试", t.toString());
        }
    }

    //每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
    public <E, S> void test() {

    }

    //类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
    public <T> T test1(List<T> list) {
        return list.get(0);
    }

    //有界的类型参数
    // extends <? extends 类>参数类型只能是该类型或者该类的子类


    //下限
    // <? super 类>参数类型只能是该类型或该类型的父类


    //泛型类  类后面加上类型参数声明部分
    //
    public class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }
    }


    //泛型通配符  ？ List<?> 理论上是List<String>，List<Integer>等所有具有类型实参的父类
    //

    //新建 就绪start 运行run 死亡 阻塞sleep suspend
    //优先级 0Thread.min_PRIORITY-10Thread.max.PRIORITY
    //implements runnable extends Thread Callable Future


}