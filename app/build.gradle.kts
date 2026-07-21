plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt.dagger)
}

android {
    namespace = "com.example.usersviewapp"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.usersviewapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    //Android
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)

    //Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui)

    //Lifecycle
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.navigation.ui.ktx)

    //RecyclerView
    implementation(libs.recyclerview)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //OkHttp
    implementation(libs.logging.interceptor)

    //Hilt
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)

    //Glide
    implementation(libs.glide)
    implementation(libs.compiler)

    //Room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)

    implementation(libs.activity.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}