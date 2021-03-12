package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = null;
                    StringBuffer buffer = new StringBuffer();
                    HttpURLConnection connection = null;
                    String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1IiwiZXhwIjoxNjA4MTc0MzU2LCJpYXQiOjE2MDc1Njk1NTYsIkFjY291bnRJbmZvIjp7ImlkIjo1LCJ1c2VyUGhvbmUiOiIxNzYqKioqMzk5OCIsImRlZmF1bHRGb2xsb3d1cElkIjozNiwib3NOYW1lIjoiQW5kcm9pZCIsInZlcnNpb24iOiIxLjAifX0.B1AxX1kpt-x4DnqyS8hMfTEjIfr7PXxRmTDhj5VD_Bc";
                    try {

                        URL url = new URL("https://gateway.huidr.com/patient/familyUser/fastLogin");
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setRequestProperty("Charset", "UTF-8");
                        connection.setRequestProperty("jwt", jwt);
                        connection.setRequestProperty("accept", "application/json");
                        connection.setRequestProperty("Connection", "Keep-Alive");
                        connection.setRequestProperty("Content-Type", "application/json");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);
                        connection.connect();
                        OutputStream outputStream = connection.getOutputStream();

                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("osName", "Android");
                        jsonObject.put("version", "1");
//                        JsonObject jsonObject=new JsonObject();
//                        jsonObject.addProperty("osName", "Android");
//                        jsonObject.addProperty("version", "1");

                        outputStream.write(jsonObject.toString().getBytes());
                        outputStream.flush();
                        outputStream.close();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String str1;


                        if (connection.getResponseCode() == 200) {
                            while ((str1 = reader.readLine()) != null) {
                                buffer.append(str1);
                            }
                            result = buffer.toString();
                        } else {
                            result = "网络异常";
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("123", e.toString());
                        result = "网络异常";

                    }

                } catch (Exception e) {

                }
            }
        }).start();

    }
}