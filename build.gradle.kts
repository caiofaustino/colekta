import org.gradle.kotlin.dsl.ktlint

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.compose.compiler) apply false

    alias(libs.plugins.ksp) apply false

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.lint) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.androidx.baselineprofile) apply false

    alias(libs.plugins.ktlint.gradle) apply true
    alias(libs.plugins.detekt) apply false
}

ktlint {
    version.set(libs.versions.ktlint.toString())
    android.set(true)
}