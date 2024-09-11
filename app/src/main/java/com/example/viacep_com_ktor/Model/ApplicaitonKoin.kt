package com.example.viacep_com_ktor.Model

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ApplicaitonKoin:Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ApplicaitonKoin)
            modules(
                appModule,
                networkModule
            )
        }
    }

}