package com.example.httptestj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.textclassifier.TextLanguage;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String urlGet = "http://www.sosoapi.com/demo/swagger/user/simple/list.htm?pageSize=10&pageNumber=1";
    private String urlPost = "http://www.sosoapi.com/demo/swagger/user/simple/add.htm";

    private OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        asyncGet();
//        syncGet();

        new Thread(new Runnable() {
            @Override
            public void run() {
                syncGet();
            }
        }).start();

        asyncPost();

        syncPost();

    }


    //
    public void asyncGet() {
        Request request = new Request.Builder()
                .url(urlGet)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "async fail:" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG, "async success:" + response.body().string());
            }
        });
    }

    //
    public void syncGet() {
        Request request = new Request.Builder().url(urlGet).build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            Log.e(TAG, "sync " + response.body().string());
        } catch (Exception e) {
            Log.e(TAG, "sync error" + e.toString());
        }
    }

    //
    public void asyncPost() {
        RequestBody requestBody = new FormBody.Builder().add("email", "906922090@qq.com").add("nickName", "无忧无虑").build();
        Request request = new Request.Builder().url(urlPost).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "async POST" + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e(TAG, "async POST" + response.body().string());
            }
        });
    }

    //
    public void syncPost() {
        RequestBody requestBody = new FormBody.Builder().add("email", "906922090@qq.com").add("nickName", "无忧无虑").build();
        final Request request = new Request.Builder().url(urlPost).post(requestBody).build();
        final Call call = okHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    Log.e(TAG, "sync POST" + response.body().string());
                } catch (Exception e) {

                }
            }
        }).start();
    }


//    response.body().string() 只能调用一次！ 因为响应主体 RessponseBody 持有的资源可能会很大，所以 OkHttp 并不会将其直接保存到内存中，只是持有数据流连接。只有当我们需要时，才会从服务器获取数据并返回。同时，考虑到应用重复读取数据的可能性很小，所以将其设计为一次性流(one-shot)，读取后即 '关闭并释放资源'。


//    异步请求方式（get请求）
//    注意1:异步请求方式，请求的回调会在子线程里，所以如果需要更新UI你需要切换到主线程。且你不需要在new 一个线程包裹这个异步请求了。另外如何切换到主线程请使用 Handler 例子：
//
//    注意2:在异步请求方法里，请不要将 public void onResponse(Call call, final Response response)回调里的response回调数据放到UI线程里解析，因为有一个天坑，有可能在UI线程里解析的时候response里面却还没有塞入数据（我也觉得很神奇，不知道写okhttp的公司是怎么想的，为什么不处理完所有数据在提供回调）

    public void aboutRequestBody() {
        RequestBody requestBody = new FormBody.Builder().add("name", "zhangsan").build();
        RequestBody requestBody1 = new RequestBody() {
            @Nullable
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {

            }
        };

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("key", "content");
        builder.addFormDataPart("filekey", "123", requestBody1);
        MultipartBody multipartBody = builder.build();

        RequestBody applicationFormUrlencodedBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=utf-8"), new String("demo").getBytes());
        RequestBody multipartBody1 = RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"), new File("/123/123"));
        RequestBody jsonBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), "content");
        RequestBody textBody = RequestBody.create(MediaType.parse("text/xml;charset=utf-8"), "content");

    }


}
