package com.atguigu.guolu;

/**
 * Created by xinpengfei on 2016/9/21.
 */
public class JNI {
    static {
        System.loadLibrary("guolu");
    }

    //native代码-得到锅炉的压力值
    public native int getPressure();
}
