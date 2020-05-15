package ru.vote

import android.app.Application
import com.orhanobut.hawk.Hawk

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Подключаем Hawk в проект
        Hawk
            .init(applicationContext)
            .build()
    }

}