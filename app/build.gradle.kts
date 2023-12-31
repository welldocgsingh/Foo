import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
//    id("com.android.application")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}



android {
    namespace = "com.wd.foo"
    compileSdk = 34

//
//    publishing {
//        singleVariant("debug") {
//            withSourcesJar()
//        }
//    }


    defaultConfig {
//        applicationId = "com.wd.foo"
        minSdk = 30
        targetSdk = 33
//        versionCode = 1
//        versionName = "1.0"

//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


//
//// add the publication before the build even starts
//// used ./gradlew mymodule:assemble --dry-run to find where to put it
//afterEvaluate {
//    tasks.clean.dependsOn("publishToMavenLocal")
//    tasks.preBuild.dependsOn("publishToMavenLocal")
//}


dependencies {

//    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")



    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(project(mapOf("path" to ":Modules")))


}


afterEvaluate {
    android.libraryVariants.forEach {variant->

        publishing.publications.create(variant.name , MavenPublication::class.java){
            from(components.findByName(variant.name))
            groupId = "com.wd"
            artifactId= "foo"
            version = "1.0.3"
        }


    }
}