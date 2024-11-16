// https://docs.gradle.org/7.0/userguide/declaring_dependencies.html#sec:type-safe-project-accessors
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "StarterProject"
include(
    ":app",
    ":library",
    ":mvi",
)

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    // If this mode is set, any repository declared directly in a project,
    // either directly or via a plugin, will trigger a build error.
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("testLibs") {
            from(files("gradle/test-libs.versions.toml"))
        }
        create("instrumentedTestLibs") {
            from(files("gradle/instrumented-test-libs.versions.toml"))
        }
    }
}


