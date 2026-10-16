plugins { id("com.android.application") }
android { namespace = "in.milkhandlingloss.app"; compileSdk = 35; defaultConfig { applicationId = "in.milkhandlingloss.app"; minSdk = 26; targetSdk = 35; versionCode = 7; versionName = "0.2.5" } }
dependencies { implementation("androidx.core:core:1.15.0") }
