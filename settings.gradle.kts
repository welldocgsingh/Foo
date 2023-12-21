pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        flatDir {
            dirs("libs")
        }
        maven("https://jitpack.io")

        maven("https://plugins.gradle.org/m2/")

    }
}



dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")

    }
}

rootProject.name = "Foo"
include(":app")
include(":Modules")
include (":library")