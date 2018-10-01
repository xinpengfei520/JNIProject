package com.atguigu.jniproject;

/**
 * Created by xinpengfei on 2016/9/20.
 */
public class JNI {

    static {
        System.loadLibrary("app");
    }

    public native String helloJNI();
}
