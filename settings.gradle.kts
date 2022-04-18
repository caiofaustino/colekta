

rootProject.name = "Starter Project"
include(":app")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@kotlin.Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    // If this mode is set, any repository declared directly in a project,
    // either directly or via a plugin, will trigger a build error.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

@kotlin.Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("coreKtx", "androidx.core", "core-ktx").version("1.7.0")

            version("compose", "1.0.1")
            library("compose.ui", "androidx.compose.ui", "ui").versionRef("compose")
            library("compose.ui.toolingPreview", "androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            library("compose.material", "androidx.compose.material", "material").versionRef("compose")
            bundle("compose", listOf("compose.ui", "compose.ui.toolingPreview", "compose.material"))
            library("compose.ui.tooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")

            library("lifecycle.runtimeKtx", "androidx.lifecycle", "lifecycle-runtime-ktx").version("2.3.1")
            library("activity.compose", "androidx.activity", "activity-compose").version("1.3.1")
        }
        create("testLibs") {
            library("junit", "junit", "junit").version("4.13.2")
        }
        create("instrumentedTestLibs") {
            library("junitExt", "androidx.test.ext", "junit").version("1.1.3")
            library("espresso", "androidx.test.espresso", "espresso-core").version("3.4.0")
            library("compose.junit4", "androidx.compose.ui", "ui-test-junit4").version("1.0.1")
        }
    }
}

