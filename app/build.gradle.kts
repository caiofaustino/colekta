plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ktlint.gradle)
    alias(libs.plugins.detekt)
}

android {
    namespace = "dev.caiofaustino.starter"
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

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
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
    implementation(projects.library)

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    ktlintRuleset(libs.ktlint.compose)
    detektPlugins(libs.detekt.compose)

    testImplementation(testLibs.junit)
    androidTestImplementation(instrumentedTestLibs.junit.ext)
    androidTestImplementation(instrumentedTestLibs.espresso)
    androidTestImplementation(instrumentedTestLibs.compose.junit4)
}
