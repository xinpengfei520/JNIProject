#include "com_atguigu_guolu_JNI.h"
#include<stdlib.h>
//
// Created by Administrator on 2016/9/21.
//

int pressure = 50;

int getPressure(){
    // 随机生成增加的压力值
    int increase = rand()%20;

    // 将增加的压力添加到总的压力值中
    pressure += increase;

    return pressure;
}

JNIEXPORT jint JNICALL Java_com_atguigu_guolu_JNI_getPressure
        (JNIEnv *env, jobject jobj){
    return getPressure();
}
