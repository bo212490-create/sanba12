# MyApp — Android NDK JNI "Hello World" Sample

A minimal Android application demonstrating a native (C++) method call via **JNI**, built with the classic **ndk-build** toolchain (`Android.mk` / `Application.mk`) instead of CMake. Useful as a starting template for native Android development in constrained environments such as AIDE.

## Features

- Native C++ function exposed to Java via JNI (`getHelloWorldString`)
- Build system based on `ndk-build` (`Android.mk` + `Application.mk`), configured through Gradle's `externalNativeBuild.ndkBuild`
- No AndroidX / Jetpack dependencies — pure legacy `android.app.Activity`
- Simple `RelativeLayout` UI updated with the string returned from native code

## Project Structure

```
MyApp/
├── app/
│   ├── build.gradle                  # Module build config, links to Android.mk
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── cpp/
│       │   └── main.cpp              # Native JNI implementation
│       ├── jni/
│       │   ├── Android.mk            # ndk-build module definition
│       │   └── Application.mk        # ABI / platform / STL config
│       ├── java/com/example/application/
│       │   └── MainActivity.java     # Loads libhello-jni.so, calls native method
│       └── res/
│           ├── drawable/ic_launcher.xml
│           ├── layout/activity_main.xml
│           └── values/
│               ├── colors.xml
│               ├── strings.xml
│               └── styles.xml
├── build.gradle                      # Top-level Gradle config
├── settings.gradle
└── .gitignore
```

> Generated build artifacts (`build/`, `gen/`, `.externalNativeBuild/`, `.cxx/`, `*.apk`, etc.) are intentionally excluded via `.gitignore` and are **not** committed to this repository.

## How It Works

1. `MainActivity` loads the native library with `System.loadLibrary("hello-jni")`.
2. It calls the native method `getHelloWorldString()`, declared in `MainActivity.java` and implemented in `app/src/main/cpp/main.cpp`.
3. The native function returns a `jstring` ("Hello World!") which is displayed in a `TextView`.
4. `Android.mk` compiles `main.cpp` into `libhello-jni.so`; `Application.mk` specifies target ABIs (`armeabi-v7a`, `arm64-v8a`, `x86`, `x86_64`), minimum platform (`android-19`), and STL (`c++_shared`).

## Requirements

- Android SDK (compileSdk 33, buildTools 33.0.0)
- Android NDK (with `ndk-build` support)
- Gradle / Android Gradle Plugin 3.5.3 (or use with AIDE, which supports `ndk-build`-based projects directly)

## Clone Repository

If you're new to Git, follow these steps to download a copy of this project to your computer.

### 1. Copy the repository

Open a terminal (Command Prompt, PowerShell, Terminal, or Termux) and run:

```bash
git clone https://github.com/bo212490-create/sanba12.git
```

### 2. Enter the project folder

```bash
cd sanba12
```

You are now inside the project directory and can build or edit the project.

> **Note:** If you do not have Git installed, you can also download the project as a ZIP file:
>
> 1. Open the GitHub repository page.
> 2. Click **Code**.
> 3. Select **Download ZIP**.
> 4. Extract the ZIP file.
> 5. Open the extracted project folder.

## Build

```bash
./gradlew assembleDebug
```

Or open the project in AIDE / Android Studio and let it invoke `ndk-build` via the configured `externalNativeBuild` block.

## License

This project is licensed under the MIT License — see [LICENSE](LICENSE) for details.
