package com.example.messages

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApplication : Application() {
    // You can add any global app initialization here if needed
    override fun onCreate() {
        super.onCreate()
        // Example: Initialize logging, analytics, or other libraries
    }
}