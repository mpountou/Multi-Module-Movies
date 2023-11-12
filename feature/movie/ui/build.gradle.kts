plugins {
    id(Plugins.com_android_library)
    id(Plugins.org_jetbrains_kotlin_android)
    kotlin(Plugins.kapt)
    id(Plugins.com_google_dagger_hilt_android)
}

android {
    namespace = "com.intelligent.movie.ui"
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
    implementation(project(Module.feature_movie_domain))
    implementation(project(Module.core_feature_api))
    implementation(project(Module.core_common))
    implementation(project(Module.core_ui))
    implementation(Dependencies.androidx_compose_navigation)
    implementation(platform(Dependencies.androidx_compose_bom))
    implementation(Dependencies.androidx_compose_ui)
    implementation(Dependencies.androidx_compose_ui_graphics)
    implementation(Dependencies.androidx_compose_ui_tooling_preview)
    implementation(Dependencies.androidx_compose_material3)
    implementation(Dependencies.google_dagger_hilt_android)
    kapt(Dependencies.google_dagger_hilt_android_compiler)
    implementation(Dependencies.androidx_hilt_navigation_compose)
    implementation(Dependencies.coil_compose)
}