#include "com_atguigu_ccalljava_JNI.h"
#include <android/log.h>

#define LOG_TAG "TAG"
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

/*
测试1: 回调一般方法(无参无返回)
*/
JNIEXPORT void JNICALL Java_com_atguigu_ccalljava_JNI_callbackHelloFromJava
(JNIEnv *env, jobject jobj){
    int i = 10;

    LOGE("i=%d\n",i);

    //1. 加载类得到jclass对象:
    //jclass (*FindClass)(JNIEnv*, const char*);
    jclass jc = (*env)->FindClass(env, "com/atguigu/ccalljava/JNI");

    //2. 得到对应方法的Method对象 : GetMethodId()
    //jmethodID (*GetMethodID)(JNIEnv*, jclass, const char*, const char*)
    // 最后一个参数：方法签名
    jmethodID jm = (*env)->GetMethodID(env, jc, "helloFromJava", "()V");
    //3. 创建类对象
    //jobject (*AllocObject)(JNIEnv*, jclass);
    //4. 调用方法(无返回值)
    //void (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...)
    (*env)->CallVoidMethod(env,jobj,jm);
}

/*
测试2: 回调带int参数方法
*/
JNIEXPORT void JNICALL Java_com_atguigu_ccalljava_JNI_callbackAdd
(JNIEnv *env, jobject jobj){
    //1. 加载类得到jclass对象:
    jclass jc = (*env)->FindClass(env, "com/atguigu/ccalljava/JNI");
    //2. 得到对应方法的Method对象 :
    jmethodID jm = (*env)->GetMethodID(env, jc, "add", "(II)I");
    //3. 创建类对象
    //4. 调用方法(无返回值)
    //jint (*CallIntMethod)(JNIEnv*, jobject, jmethodID, ...)
    (*env)->CallIntMethod(env,jobj,jm,1,1);
}

/*
测试3: 回调带String参数方法

*/
JNIEXPORT void JNICALL Java_com_atguigu_ccalljava_JNI_callbackPrintString
(JNIEnv *env, jobject jobj){
    //1. 加载类得到jclass对象:
    jclass jc = (*env)->FindClass(env, "com/atguigu/ccalljava/JNI");
    //2. 得到对应方法的Method对象 :
    jmethodID jm = (*env)->GetMethodID(env, jc, "printString", "(Ljava/lang/String;)V");
    //3. 创建类对象
    //4. 调用方法(带String参数的无返回值)
    //void (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...)
    jstring jstr = (*env)->NewStringUTF(env, "0714zuibang nimenzuiqiang");
    (*env)->CallVoidMethod(env, jobj, jm, jstr);
}

/*
测试4: 回调静态方法

*/
JNIEXPORT void JNICALL Java_com_atguigu_ccalljava_JNI_callbackSayHello
(JNIEnv *env, jobject jobj){
   //1. 加载类得到jclass对象:
    jclass jc = (*env)->FindClass(env, "com/atguigu/ccalljava/JNI");
    //2. 得到对应方法的Method对象 :
    //jmethodID (*GetStaticMethodID)(JNIEnv*, jclass, const char*, const char*)
    jmethodID jm = (*env)->GetStaticMethodID(env, jc, "sayHello", "(Ljava/lang/String;)V");
    //3. 调用方法
    //void (*CallStaticVoidMethod)(JNIEnv*, jclass, jmethodID, ...)
    jstring jstr = (*env)->NewStringUTF(env, "hello nihao");

    (*env)->CallStaticVoidMethod(env, jc, jm, jstr);
}

/**
小应用: 回调更新UI的方法
*/
JNIEXPORT void JNICALL Java_com_atguigu_ccalljava_JNI_callbackShowToast
(JNIEnv *env, jobject jobj){
 //1. 加载类得到jclass对象:
    jclass jc = (*env)->FindClass(env, "com/atguigu/ccalljava/JNI");
    //2. 得到对应方法的Method对象
    jmethodID jm = (*env)->GetMethodID(env, jc, "showToast", "()V");
    //3. 调用方法
    (*env)->CallVoidMethod(env, jobj, jm);
}