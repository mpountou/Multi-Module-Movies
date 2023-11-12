plugins {
    id(Plugins.com_android_library)
    id(Plugins.org_jetbrains_kotlin_android)
}

android {
    namespace = "com.intelligent.core.common"
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
    implementation(Dependencies.androidx_appcompat)
}