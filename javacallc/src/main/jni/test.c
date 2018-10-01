#include "com_atguigu_javacallc_JNI.h"
#include <string.h>


/**
 * 工具函数
 * 把一个jstring转换成一个c语言的char* 类型.
 */
char *_JString2CStr(JNIEnv *env, jstring jstr) {

    char *rtn;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env, "GB2312");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid,
                                                           strencode); // String .getByte("GB2312");
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte *ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1); //"\0"
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba, 0);
    return rtn;
}

/**
 * 求两个数的和
 */
JNIEXPORT jint

JNICALL Java_com_atguigu_javacallc_JNI_sum
        (JNIEnv *env, jobject jobj, jint x, jint y) {
    return x + y;
}

/**
 * 字符串拼接,将两个字符串拼接后返回
 * env:Java和c之间常用的翻译方法；jobj：类对象
 */
JNIEXPORT jstring

JNICALL Java_com_atguigu_javacallc_JNI_sayHello
        (JNIEnv *env, jobject jobj, jstring jstr) {

    //1.将jstring类型的js转换为char*类型的数据
    char *pChar1 = _JString2CStr(env, jstr);

    //2. 指定另一部分字符串
    char *pChar2 = "hello nihao";

    //3. 将拼接两个char*类型字符串拼接在第一个上
    //string.h---char* strcat(char *, const char *);
    char *pChar3 = strcat(pChar1, pChar2);

    //4. 将结果转换为jstring类型返回
    //jstring (*NewStringUTF)(JNIEnv*, const char*)
    return (*env)->NewStringUTF(env, pChar3);
}

/**
 * 数组练习: 将数组中的每个元素增加10
 *
 * (方式一)
 * 1. 得到数组的长度
 * jsize (*GetArrayLength)(JNIEnv*, jarray);
 * 2. 得到数组
 * jint* (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
 * 3. 遍历数组, 并将每个元素+10
 * 4. 返回数组
 */

//（方式二）:
JNIEXPORT jintArray

JNICALL Java_com_atguigu_javacallc_JNI_increaseArrayEles
        (JNIEnv *env, jobject jobj, jintArray jarr) {
    //1. 得到数组的长度
    //jsize       (*GetArrayLength)(JNIEnv*, jarray);
    jsize length = (*env)->GetArrayLength(env, jarr);

    // 2.根据得到的数组长度，创建本地jint类型数组
    jint nativeArr[length];

    // 3.将传入的数组赋值给本地数组
    //(*env)->GetIntArrayRegion();
    (*env)->GetIntArrayRegion(env, jarr, 0, length, nativeArr);
    // 4.遍历数组修改相应值
    int i;
    for (i = 0; i < length; i++) {
        nativeArr[i] += 10;
    }

    // 5.将修改后的数组赋值给传入的数组
    // (*env)->SetIntArrayRegion();
    (*env)->SetIntArrayRegion(env, jarr, 0, length, nativeArr);

    // 6.返回修改后的数组
    return jarr;
}

/**
 * 检查密码是否正确
 */
JNIEXPORT jint

JNICALL Java_com_atguigu_javacallc_JNI_checkPwd
        (JNIEnv *env, jobject jobj, jstring jstr) {

    //1. 将jString转换为char*
    char *pChar1 = _JString2CStr(env, jstr);
    //2. 定义已保存的密码
    char *pPassword = "123456";

    //3. 比较两个字符串是否相等
    //string.h---int strcmp(const char *, const char *)
    int result = strcmp(pChar1, pPassword);

    if (result == 0) {
        return 200;
    } else {
        return 404;
    }
//4. 根据比较的结果返回不同的值
}