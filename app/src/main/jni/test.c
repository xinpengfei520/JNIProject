//
// Created by Administrator on 2016/9/20.
//
#include "com_atguigu_jniproject_JNI.h"

JNIEXPORT jstring JNICALL Java_com_atguigu_jniproject_JNI_helloJNI
  		(JNIEnv * env, jobject jobj) {

  			return (*env)->NewStringUTF(env, "Hello from C");
		}
