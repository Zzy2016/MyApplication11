package com.example.httptestj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    private FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        getAsync();
//        getSync();

        postWithString();
        postSummit();
//        postSummitFile();
        postSummitForm();

        aboutIntercept();

    }

    //异步Get
    public void getAsync() {
        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG + " async get", "error " + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG + " async get", "success " + response.body().string());
            }
        });
    }

    //同步Get
    public void getSync() {
        String url = "http://wwww.baidu.com";
        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    Log.e(TAG, "sync get " + response.body().string());
                } catch (Exception e) {
                    Log.e(TAG, "sync get " + e.toString());
                }
            }
        }).start();
    }

    /*
     * Post需要构造一个RequestBody携带提交的数据，构造RequestBody时指定MediaType
     * */
    //Post
    public void postWithString() {
        MediaType mediaType = MediaType.parse("text/x-markdown;charset=utf-8");
        final String requestBody = "I am Jdqm.";
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "异步 post error" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG, "异步 post" + response.body().string());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    Log.e(TAG, "异步" + headers.name(i) + " : " + headers.value(i) + "  ");

                }
            }
        });

    }

    //post提交流
    public void postSummit() {
        RequestBody requestBody = new RequestBody() {
            @Nullable
            @Override
            public MediaType contentType() {
                return MediaType.parse("text/x-markdown;charset=utf-8");
            }

            @Override
            public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
                bufferedSink.writeUtf8("I am Jdqm.");
            }
        };
        final Request request = new Request.Builder().post(requestBody).url("https://api.github.com/markdown/raw")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG, "post " + response.body().string());
            }
        });
    }

    //post提交文件
    public void postSummitFile() {
        MediaType mediaType = MediaType.parse("text/x-markdown;charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        File file = new File("");
        Request request = new Request.Builder().url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, file))
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "提交文件" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG, "提交文件" + response.body().string());
            }
        });
    }

    //提交表单
    public void postSummitForm() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder().add("search", "Jurassic Park").build();
        Request request = new Request.Builder().url("https://en.wikipedia.org/w/index.php").post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "提交form" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG, "提交form" + response.body().string());
            }
        });
    }

    public void aboutIntercept() {
        Request request = new Request.Builder().url("http://wwww.baidu.com")
                .header("User-Agent", "OkHttp Example")
                .build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("测试", response.body().string());
            }
        });


    }


}