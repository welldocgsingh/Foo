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

        maven("https://maven.google.com")
    }
}



dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()

        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")

        maven("https://maven.google.com")
    }
}

rootProject.name = "Foo"
include(":app")
include(":Modules")
//include (":library")