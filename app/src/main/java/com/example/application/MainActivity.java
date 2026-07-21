package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * MainActivity nạp thư viện libhello-jni.so được quản lý bởi hệ thống build ndk-build (Android.mk).
 */
public class MainActivity extends Activity {

    // Định nghĩa phương thức Native lấy chuỗi từ C++
    public native String getHelloWorldString();

    static {
        // Nạp thư viện hello-jni
        System.loadLibrary("hello-jni");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ thành phần UI hiển thị
        TextView tvHelloWorld = findViewById(R.id.tv_hello_world);

        // Gọi phương thức Native nhận chuỗi và cập nhật giao diện
        String message = getHelloWorldString();
        tvHelloWorld.setText(message);
    }
}
