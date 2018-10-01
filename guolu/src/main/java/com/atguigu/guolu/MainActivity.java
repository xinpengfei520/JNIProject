package com.atguigu.guolu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv_yalizhi;
    private ProgressBar pb_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_yalizhi = (TextView) findViewById(R.id.tv_yalizhi);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
        pb_progress.setMax(250);

        initData();
    }

    private void initData() {

        final JNI jni = new JNI();

        new Thread() {
            public void run() {
                while (true) {
                    // 获取压力值
                    final int pressure = jni.getPressure();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    // 更新压力显示
                                    pb_progress.setProgress(pressure);

                                }
                            });

                            if (pressure < 200) {
                                tv_yalizhi.setText("压力值为：" + pressure);
                                tv_yalizhi.setTextColor(Color.GREEN);
                            } else if (pressure < 250) {
                                tv_yalizhi.setText("压力值为：" + pressure);
                                tv_yalizhi.setTextColor(Color.RED);
                            } else {
                                tv_yalizhi.setText("要爆炸了快跑！");
                                pb_progress.setVisibility(View.GONE);
                            }
                        }
                    });

                    // 延时
                    SystemClock.sleep(500);

                }
            }
        }.start();
    }
}
