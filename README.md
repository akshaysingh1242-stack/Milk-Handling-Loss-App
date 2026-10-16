name: Build Milk Handling Loss APK

on:
  workflow_dispatch:
  push:
    branches: [main, master]

permissions:
  contents: read

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout repository
        uses: actions/checkout@v4

      - name: Set up Java
        uses: actions/setup-java@v5
        with:
          distribution: temurin
          java-version: '17'

      - name: Configure Android SDK
        run: |
          echo "ANDROID_HOME=$ANDROID_HOME" >> "$GITHUB_ENV"
          echo "$ANDROID_HOME/platform-tools" >> "$GITHUB_PATH"
          echo "$ANDROID_HOME/cmdline-tools/latest/bin" >> "$GITHUB_PATH"

      - name: Install Android SDK packages
        run: |
          SDKMANAGER=$(find "$ANDROID_HOME/cmdline-tools" -type f -name sdkmanager | head -n 1)
          if [ -z "$SDKMANAGER" ]; then
            echo "sdkmanager not found"
            exit 1
          fi
          yes | "$SDKMANAGER" --licenses || true
          "$SDKMANAGER" --install "platforms;android-35" "build-tools;35.0.0"

      - name: Find and extract project ZIP
        run: |
          ZIP_FILE=$(find . -maxdepth 1 -type f -iname '*.zip' -print -quit)
          if [ -z "$ZIP_FILE" ]; then
            echo "Project ZIP not found"
            exit 1
          fi
          mkdir -p source
          unzip -o "$ZIP_FILE" -d source
          PROJECT_DIR=$(dirname "$(find source -name settings.gradle.kts -print -quit)")
          if [ -z "$PROJECT_DIR" ] || [ ! -f "$PROJECT_DIR/app/build.gradle.kts" ]; then
            echo "Android project structure not found in ZIP"
            exit 1
          fi
          echo "PROJECT_DIR=$PROJECT_DIR" >> "$GITHUB_ENV"

      - name: Set up Gradle
        uses: gradle/actions/setup-gradle@v4

      - name: Build APK
        run: gradle --no-daemon -p "$PROJECT_DIR" assembleDebug --stacktrace

      - name: Upload APK
        uses: actions/upload-artifact@v4
        with:
          name: Milk-Handling-Loss-debug-apk
          path: source/**/app/build/outputs/apk/debug/*.apk
          if-no-files-found: error
