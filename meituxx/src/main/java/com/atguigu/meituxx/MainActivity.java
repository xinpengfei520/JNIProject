package com.atguigu.meituxx;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mt.mtxx.image.JNI;

public class MainActivity extends Activity {

    private ImageView iv_icon;
    private JNI jni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jni = new JNI();
        iv_icon = (ImageView)findViewById(R.id.iv_icon);
    }

    /*
	实现高亮效果
    */
    public void lomoHDR(View v) {
        //1. 得到图片的像素数组
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);

        /*
            pixels       接收位图颜色值的数组
            offset      写入到pixels[]中的第一个像素索引值
            stride       pixels[]中的行间距个数值(必须大于等于位图宽度)。
            x             从位图中读取的第一个像素的x坐标值。
            y             从位图中读取的第一个像素的y坐标值
            width      从每一行中读取的像素宽度
            height 　读取的行数
         */
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        //2. 调用native方法处理数据 ;
        // 参数pixels像素数组；图片宽度；图片高度
        jni.StyleLomoHDR(pixels,bitmap.getWidth(),bitmap.getHeight());

        //3. 返回回来重新生成图片
        Bitmap newBitmap = Bitmap.createBitmap(pixels, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        //4. 显示
        iv_icon.setImageBitmap(newBitmap);
    }

    public void lomoC(View v) {
        //1. 得到图片的像素数组
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);

        /*
            pixels       接收位图颜色值的数组
            offset      写入到pixels[]中的第一个像素索引值
            stride       pixels[]中的行间距个数值(必须大于等于位图宽度)。
            x             从位图中读取的第一个像素的x坐标值。
            y             从位图中读取的第一个像素的y坐标值
            width      从每一行中读取的像素宽度
            height 　读取的行数
         */
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        //2. 调用native方法处理数据 ;
        // 参数pixels像素数组；图片宽度；图片高度
        jni.StyleLomoC(pixels, bitmap.getWidth(), bitmap.getHeight());

        //3. 返回回来重新生成图片
        Bitmap newBitmap = Bitmap.createBitmap(pixels, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        //4. 显示
        iv_icon.setImageBitmap(newBitmap);
    }
    public void lomoB(View v) {
        //1. 得到图片的像素数组
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.girl);

        /*
            pixels       接收位图颜色值的数组
            offset      写入到pixels[]中的第一个像素索引值
            stride       pixels[]中的行间距个数值(必须大于等于位图宽度)。
            x             从位图中读取的第一个像素的x坐标值。
            y             从位图中读取的第一个像素的y坐标值
            width      从每一行中读取的像素宽度
            height 　读取的行数
         */
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        //2. 调用native方法处理数据 ;
        // 参数pixels像素数组；图片宽度；图片高度
        jni.StyleLomoB(pixels,bitmap.getWidth(),bitmap.getHeight());

        //3. 返回回来重新生成图片
        Bitmap newBitmap = Bitmap.createBitmap(pixels, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        //4. 显示
        iv_icon.setImageBitmap(newBitmap);
    }

    public void reset(View v) {
        iv_icon.setImageResource(R.drawable.girl);
    }
}
