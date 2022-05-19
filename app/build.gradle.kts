plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin.android)
    codeChecks
}

android {
    namespace = "dev.caiofaustino.starter"
    compileSdk = 32

    defaultConfig {
        applicationId = "dev.caiofaustino.starter"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.bundles.compose)
    implementation(libs.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    testImplementation(testLibs.junit)
    androidTestImplementation(instrumentedTestLibs.junit.ext)
    androidTestImplementation(instrumentedTestLibs.espresso)
    androidTestImplementation(instrumentedTestLibs.compose.junit4)
}
