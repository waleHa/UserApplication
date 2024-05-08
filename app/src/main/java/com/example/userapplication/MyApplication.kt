package com.example.userapplication

import android.app.Application
import com.example.userapplication.data.network.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.ERROR)  // Set log level to error to avoid too much log clutter
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}