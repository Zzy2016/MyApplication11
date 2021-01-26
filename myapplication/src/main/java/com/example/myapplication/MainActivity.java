package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databinding.ActivityMainBinding;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


//Observable
//Observer
//subscribe
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share_intent = new Intent();
                share_intent.setAction(Intent.ACTION_SEND);//设置分享行为
                share_intent.setType("text/plain");//设置分享内容的类型
                share_intent.putExtra(Intent.EXTRA_SUBJECT, "share");//添加分享内容标题
                share_intent.putExtra(Intent.EXTRA_TEXT, "share with you:"+"android");//添加分享内容
                //创建分享的Dialog
                share_intent = Intent.createChooser(share_intent, "share");
                startActivity(share_intent);
            }
        });


//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onError(new Throwable("123"));
//                emitter.onNext(3);
//                emitter.onComplete();
//            }
//        });
//
//
//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.e("-------------", "onSubscribe");
//            }
//
//            @Override
//            public void onNext(Object o) {
//                Log.e("-------------", "onNext  " + o);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e("-------------", "onError" + e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.e("-------------", "onComplete");
//            }
//        };
//
//
//        observable.subscribe(observer);
//
//
//        // 相同点：二者基本使用方式完全一致（实质上，在RxJava的 subscribe 过程中，Observer总是会先被转换成Subscriber再使用）
//// 不同点：Subscriber抽象类对 Observer 接口进行了扩展，新增了两个方法：
//        // 1. onStart()：在还未响应事件前调用，用于做一些初始化工作
//        // 2. unsubscribe()：用于取消订阅。在该方法被调用后，观察者将不再接收 & 响应事件
//        // 调用该方法前，先使用 isUnsubscribed() 判断状态，确定被观察者Observable是否还持有观察者Subscriber的引用，
//        // 如果引用不能及时释放，就会出现内存泄露
//        Subscriber<String> subscriber = new Subscriber<String>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//
//
//        };
//
//
//        Observable.just("hello").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.e("-------------", "accept  " + s);
//            }
//        });
//        Observer observer1 = new Observer() {
//
//            private Disposable disposable;
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                disposable = d;
//            }
//
//            @Override
//            public void onNext(Object o) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                disposable.dispose();
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//        Observable.just("path").map(new Function<String, String>() {
//            @Override
//            public String apply(String s) throws Exception {
//                return null;
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//
//            }
//        });

//        Observable.just("hello").compose()


    }
}
