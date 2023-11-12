plugins {
    id(Plugins.com_android_library)
    id(Plugins.org_jetbrains_kotlin_android)
}

android {
    namespace = "com.intelligent.ui"
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
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlin_compiler_extension_version
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(Dependencies.androidx_appcompat)
    implementation(Dependencies.androidx_compose_navigation)
    implementation(platform(Dependencies.androidx_compose_bom))
    implementation(Dependencies.androidx_compose_ui)
    implementation(Dependencies.androidx_compose_ui_graphics)
    implementation(Dependencies.androidx_compose_ui_tooling_preview)
    implementation(Dependencies.androidx_compose_material3)
    implementation(Dependencies.androidx_hilt_navigation_compose)
    implementation(Dependencies.coil_compose)
}