// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra.apply {
        set("room_version", "2.6.1")
    }
}

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false

    // Hilt
    id("com.google.dagger.hilt.android") version "2.51.1" apply false

    //Ksp
    id("com.google.devtools.ksp") version "1.9.23-1.0.20" apply false
}