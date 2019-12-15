package io.github.itakahiro.architecturefootball

import android.app.Application
import androidx.room.Room
import io.github.itakahiro.architecturefootball.data.db.AppDatabase

class Application : Application() {
    companion object {
        lateinit var playCallDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        playCallDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "play_call_database"
        ).build()
    }
}