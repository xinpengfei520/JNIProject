package com.atguigu.javacallc;

/**
 * Created by xinpengfei on 2016/9/20.
 */
public class JNI {

    static {
        System.loadLibrary("javacallc");
    }

    //求两个数的和
    public native int sum(int x, int y);

    //拼接字符串
    public native String sayHello(String s);

    //数组
    public native int[] increaseArrayEles(int[] intArray);

    //检查密码是否正确, 如果正确返回200, 否则返回400
    public native int checkPwd(String pwd);
}
