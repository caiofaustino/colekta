plugins {
    alias(libs.plugins.android.app) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false

    alias(libs.plugins.ktlint.gradle) apply true
    alias(libs.plugins.detekt) apply false
}

ktlint {
    version.set(libs.versions.ktlint.toString())
    android.set(true)
}