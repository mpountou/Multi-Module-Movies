plugins {
    id("com.android.application")
    id(Plugins.org_jetbrains_kotlin_android)
    kotlin(Plugins.kapt)
    id(Plugins.com_google_dagger_hilt_android)
}

android {
    namespace = "com.intelligent.multi_module_movies"
    compileSdk = Android.compile_and_target_sdk

    defaultConfig {
        applicationId = "com.intelligent.multi_module_movies"
        minSdk = Android.min_sdk
        targetSdk = Android.compile_and_target_sdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlin_compiler_extension_version
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(Dependencies.androidx_core_ktx)
    implementation(Dependencies.androidx_lifecycle_runtime)
    implementation(Dependencies.androidx_activity_compose)
    implementation(platform(Dependencies.androidx_compose_bom))
    implementation(Dependencies.androidx_compose_ui)
    implementation(Dependencies.androidx_compose_ui_graphics)
    implementation(Dependencies.androidx_compose_ui_tooling_preview)
    implementation(Dependencies.androidx_compose_material3)
    implementation(Dependencies.google_dagger_hilt_android)
    kapt(Dependencies.google_dagger_hilt_android_compiler)
    implementation(Dependencies.androidx_compose_navigation)
    implementation(Dependencies.androidx_hilt_navigation_compose)

    // feature modules
    implementation(project(Module.feature_movie_ui))
    implementation(project(Module.feature_movie_data))
    implementation(project(Module.feature_movie_details_ui))
    implementation(project(Module.feature_movie_details_data))

    // common
    implementation(project(Module.core_common))
    implementation(project(Module.core_network))
    implementation(project(Module.core_feature_api))


}