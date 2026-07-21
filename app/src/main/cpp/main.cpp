#include <jni.h>

extern "C" {

/**
 * Trả về chuỗi "Hello World!" cho lớp Java.
 * JNIEXPORT và JNICALL bảo đảm hàm được xuất đúng định dạng kết nối hệ thống.
 */
JNIEXPORT jstring JNICALL
Java_com_example_application_MainActivity_getHelloWorldString(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("Hello World!");
}

}
