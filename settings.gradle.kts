

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

    versionCatalogs {
        create("testLibs") {
            from(files("gradle/test-libs.versions.toml"))
        }
        create("instrumentedTestLibs") {
            from(files("gradle/instrumented-test-libs.versions.toml"))
        }
    }
}

