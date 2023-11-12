object Plugins {
    const val com_android_library = "com.android.library"
    const val org_jetbrains_kotlin_android = "org.jetbrains.kotlin.android"
    const val kapt = "kapt"
    const val com_google_dagger_hilt_android = "com.google.dagger.hilt.android"
}

object Versions {
    const val kotlin_compiler_extension_version = "1.4.0-alpha01"
    const val compose_version = "1.2.1"
    const val compose_compiler = "1.3.2"

    object AndroidX {
        const val activityCompose = "1.4.0"
        const val compose = compose_version
        const val compose_bom_version = "2023.03.00"
        const val core = "1.8.0"
        const val lifecycle = "2.5.1"
        const val navigation = "2.5.1"
        const val dagger_navigation_version = "1.0.0-alpha03"
        const val app_compat = "1.6.1"
    }
    const val retrofit = "2.9.0"
    const val logging_interceptor = "5.0.0-alpha.3"
    const val coil_compose = "2.4.0"
    object Google {
        const val dagger_version = "2.44"
    }
}

object Android {
    const val min_sdk = 26
    const val compile_and_target_sdk = 34
    const val jvm_target = "17"
}

// Synchronized dependencies used by (some) modules
@Suppress("Unused", "MaxLineLength")
object Dependencies {
    const val androidx_activity_compose =
        "androidx.activity:activity-compose:${Versions.AndroidX.activityCompose}"
    const val androidx_compose_navigation =
        "androidx.navigation:navigation-compose:${Versions.AndroidX.navigation}"
    const val androidx_core_ktx = "androidx.core:core-ktx:${Versions.AndroidX.core}"
    const val androidx_lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycle}"

    const val androidx_compose_bom =
        "androidx.compose:compose-bom:${Versions.AndroidX.compose_bom_version}"
    const val androidx_compose_ui = "androidx.compose.ui:ui"
    const val androidx_compose_ui_graphics = "androidx.compose.ui:ui-graphics"
    const val androidx_compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview"
    const val androidx_compose_material3 = "androidx.compose.material3:material3"

    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.app_compat}"

    const val google_dagger_hilt_android =
        "com.google.dagger:hilt-android:${Versions.Google.dagger_version}"
    const val google_dagger_hilt_android_compiler =
        "com.google.dagger:hilt-android-compiler:${Versions.Google.dagger_version}"
    const val androidx_hilt_navigation_compose =
        "androidx.hilt:hilt-navigation-compose:${Versions.AndroidX.dagger_navigation_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofit_logging = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"

    const val coil_compose = "io.coil-kt:coil-compose:${Versions.coil_compose}"
}

object Module {
    const val feature_movie_ui = ":feature:movie:ui"
    const val feature_movie_domain = ":feature:movie:domain"
    const val feature_movie_data = ":feature:movie:data"
    const val feature_movie_details_ui = ":feature:movie_details:ui"
    const val feature_movie_details_domain = ":feature:movie_details:domain"
    const val feature_movie_details_data = ":feature:movie_details:data"

    const val core_common = ":core:common"
    const val core_network = ":core:network"
    const val core_feature_api = ":core:feature_api"
    const val core_ui = ":core:ui"
}