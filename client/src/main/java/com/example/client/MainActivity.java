package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        String path = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxf47607581149e011&secret=cc7aa6caa5bd1406406b6b2c77c3088f";

                        String result = doGetHttp(path);
                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            getCode(jsonObject.getString("access_token"));
                            Log.e("code--->", jsonObject.getString("access_token"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.e("--------", result);
                    }
                }
        ).start();

    }

    public String doGetHttp(String path) {
        String result = "";
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            StringBuffer buffer = new StringBuffer();
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String str1;
                while ((str1 = reader.readLine()) != null) {
                    buffer.append(str1);
                }
                result = buffer.toString();
            } else {
                result = "网络异常";
            }
        } catch (Exception e) {
            Log.e("异常", e.toString());
            result = "网络异常";
        }
        return result;
    }


    public void getCode(String token) {
        try {
            URL url = new URL("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + token);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            // conn.setConnectTimeout(10000);//连接超时 单位毫秒
            // conn.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            JSONObject paramJson = new JSONObject();
            //这就是你二维码里携带的参数 String型  名称不可变
            paramJson.put("scene", "133");
            //注意该接口传入的是page而不是path
//            paramJson.put("page", page);
            //这是设置扫描二维码后跳转的页面
            paramJson.put("width", 200);
            paramJson.put("is_hyaline", true);
            paramJson.put("auto_color", true);
            printWriter.write(paramJson.toString());
            // flush输出流的缓冲
            printWriter.flush();
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(baos.toByteArray(), 0, baos.toByteArray().length);
                    img.setImageBitmap(bitmap);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("exception", e.toString());
        }
    }


}