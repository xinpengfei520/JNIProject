package com.atguigu.javacallc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 求和
        JNI jni = new JNI();
        int sum = jni.sum(1,2);
        Log.e("TAG", sum + "");

        //测试2: 将两个字符串拼接后返回
        String msgs = jni.sayHello("0714");
        Log.e("TAG", msgs);

        // 测试3:将数组中的每个元素增加10
        int[] arr = {1,2,3};
        int[] newArr = jni.increaseArrayEles(arr);

        for (int i = 0; i< newArr.length; i++){
            Log.e("TAG", ""+newArr[i]);
        }

        // 小应用: 检查密码是否正确
        int result = jni.checkPwd("123456");
        Log.e("TAG", ""+result);
    }
}
