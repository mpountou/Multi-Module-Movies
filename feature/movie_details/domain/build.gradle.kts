plugins {
    id(Plugins.com_android_library)
    id(Plugins.org_jetbrains_kotlin_android)
    kotlin(Plugins.kapt)
    id(Plugins.com_google_dagger_hilt_android)
}

android {
    namespace = "com.intelligent.feature.movie_details.domain"
    compileSdk = Android.compile_and_target_sdk

    defaultConfig {
        minSdk = Android.min_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Android.jvm_target
    }
}

dependencies {
    implementation(project(Module.core_common))
    implementation(Dependencies.androidx_appcompat)
    implementation(Dependencies.google_dagger_hilt_android)
    kapt(Dependencies.google_dagger_hilt_android_compiler)
}