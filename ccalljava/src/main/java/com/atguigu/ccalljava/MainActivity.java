package com.atguigu.ccalljava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private JNI jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jni = new JNI(this);

        initData();// alt+shift+q抽取成方法
    }

    private void initData() {
        jni.callbackHelloFromJava();
        jni.callbackAdd();
        jni.callbackPrintString();
        jni.callbackSayHello();
    }

    /**
     * 点击回调
     *
     * @param v
     */
    public void clickme(View v) {
        jni.callbackShowToast();
    }
}
