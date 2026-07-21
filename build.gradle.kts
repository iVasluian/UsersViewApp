// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    id ("com.google.dagger.hilt.android") version "2.60.1" apply false
    kotlin("kapt") version "2.4.10"
}

buildscript {
    repositories {
        maven { url = uri("https://www.jitpack.io") }
    }
}