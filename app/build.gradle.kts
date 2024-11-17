import org.gradle.kotlin.dsl.detekt

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ktlint.gradle)
    alias(libs.plugins.detekt)
}

android {
    namespace = "dev.caiofaustino.colekta"
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        applicationId = ProjectConfig.APP_ID
        minSdk = ProjectConfig.MIN_SDK
        targetSdk = ProjectConfig.TARGET_SDK
        versionCode = ProjectConfig.VERSION_CODE
        versionName = ProjectConfig.VERSION_NAME

        testInstrumentationRunner = ProjectConfig.ANDROID_JUNIT_RUNNER

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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

detekt {
    config.setFrom(
        rootDir.resolve("config/detekt/detekt.yml"),
    )
}

dependencies {
    implementation(projects.mvi)

    // https://developer.android.com/jetpack/androidx/releases/core
    implementation(libs.androidx.core.ktx)
        ?.because("Better support for older Android versions")
    // https://developer.android.com/jetpack/androidx/releases/lifecycle#kts
    implementation(libs.androidx.lifecycle.viewmodel)
        ?.because("Adds ViewModel and sub-utilities.")
    implementation(libs.androidx.lifecycle.viewmodel.compose)
        ?.because("ViewModel utilities for Compose")
    implementation(libs.androidx.lifecycle.runtime.compose)
        ?.because("Lifecycle utilities for Compose")

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)

    debugImplementation(libs.compose.ui.tooling)
//    debugImplementation(libs.compose.ui.test.manifest)

    ktlintRuleset(libs.ktlint.compose)
    detektPlugins(libs.detekt.compose)

    testImplementation(testLibs.junit)
    androidTestImplementation(instrumentedTestLibs.androidx.junit)
    androidTestImplementation(instrumentedTestLibs.androidx.espresso.core)
    androidTestImplementation(platform(instrumentedTestLibs.androidx.compose.bom))
    androidTestImplementation(instrumentedTestLibs.compose.ui.test.junit4)
}
