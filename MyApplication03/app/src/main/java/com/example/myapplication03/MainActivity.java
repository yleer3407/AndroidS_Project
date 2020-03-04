package com.example.myapplication03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.WindowManager;
import android.widget.Chronometer;
//计时器
public class MainActivity extends AppCompatActivity {
    Chronometer ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示
        ch=findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setFormat("%s");
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-ch.getBase()>=60000){
                    ch.stop();
                }
            }
        });
    }
}
