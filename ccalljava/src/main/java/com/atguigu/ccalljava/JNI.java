package com.atguigu.ccalljava;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by xinpengfei on 2016/9/20.
 */
public class JNI {

    static {
        System.loadLibrary("ccalljava");
    }

    private Context mContext;

    public JNI(Context context) {
        mContext = context;
    }

    public native void callbackHelloFromJava();
    public native void callbackAdd();
    public native void callbackPrintString();
    public native void callbackSayHello();


    public void helloFromJava() {
        Log.e("TAG", "helloFromJava()");
    }
    public int add(int x, int y) {
        Log.e("TAG","add() x=" + x+" y="+y);
        return x + y;
    }

    public void printString(String s) {
        Log.e("TAG","C中输入的：" + s);
    }

    public static void sayHello(String s){
        Log.e("TAG",  "我是java代码中的JNI."
                + "java中的sayHello(String s)静态方法，我被C调用了:"+ s);
    }


    //此方法必须定义在Activity中
    public native void callbackShowToast();

    public void showToast(){
        Toast.makeText(mContext, "C调用显示出来的哦", Toast.LENGTH_SHORT).show();
    }
}
