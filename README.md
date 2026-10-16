# Milk Handling Loss Android App

Native Android Java project. Local SQLite storage, report/export starter implementation.

## Build APK

Requirements: JDK 17, Android SDK platform 35 and build-tools 35.0.0, Gradle compatible with Android Gradle Plugin 8.7.3.

Build command:

```sh
gradle --no-daemon assembleDebug
```

APK output: `app/build/outputs/apk/debug/app-debug.apk`.

A GitHub Actions workflow is included at `.github/workflows/build-apk.yml`. Push this project to a GitHub repository, then open **Actions** and run **Build Milk Handling Loss APK**. On success, download the APK from the run's **Artifacts** section. Build success and device behavior have not yet been verified in this environment.
