package com.example.educonnect

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EduConnectApplication: Application()
{
    override fun onCreate() {
        super.onCreate()

    }
}