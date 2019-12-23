package io.github.itakahiro.architecturefootball

import android.app.Application
import androidx.room.Room
import io.github.itakahiro.architecturefootball.data.db.AppDatabase

class Application : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "database"
        ).build()
    }
}