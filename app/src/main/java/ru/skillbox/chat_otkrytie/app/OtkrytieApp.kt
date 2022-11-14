package ru.skillbox.chat_otkrytie.app

import android.app.Application
import ru.skillbox.chat_otkrytie.BuildConfig
import timber.log.Timber

class OtkrytieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}