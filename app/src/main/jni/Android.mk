LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := hello-jni
LOCAL_SRC_FILES := ../cpp/main.cpp

include $(BUILD_SHARED_LIBRARY)
