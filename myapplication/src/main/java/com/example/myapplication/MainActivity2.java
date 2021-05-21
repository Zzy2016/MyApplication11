package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "LauncherMode2";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActivityListTest.getInstance().addActivity(this);

//        getWindow().setEnterTransition(new Explode().setDuration(2000));
//        getWindow().setExitTransition(new Explode().setDuration(2000));



//        getWindow().setEnterTransition(new Slide().setDuration(2000));
//        getWindow().setExitTransition(new Slide().setDuration(2000));


//        getWindow().setEnterTransition(new Fade().setDuration(2000));
//        getWindow().setExitTransition(new Fade().setDuration(2000));

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Log.e(TAG, ActivityListTest.getInstance().getActivities().toString());


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityListTest.getInstance().removeActivities(this);
    }
}