package com.example.myapplication04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
//进度条加载 明日学院P51
public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int mProgress = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what==0x111){
                    progressBar.setProgress(mProgress);

                }else {
                    Toast.makeText(MainActivity.this, "耗时操作已完成", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);//进度条不显示
                }
            }
        };
        /**
         * 创建线程 软件更新不可以在主线程进行
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgress =doWork();  //doWork 耗时操作
                    Message m = new Message();
                    if (mProgress<100){  //判断当前进行是否完成
                        m.what = 0x111; //0x111 自定义的消息代码 默认0x开头
                        mHandler.sendMessage(m);
                    }else {
                        m.what=0x110;
                        mHandler.sendMessage(m);
                        break;      //退出while语句
                    }
                }
            }
            private int doWork(){
                mProgress+=Math.random()*10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgress;
            }
        }).start();
    }
}
