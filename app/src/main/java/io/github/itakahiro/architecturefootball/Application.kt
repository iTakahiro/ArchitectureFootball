package io.github.itakahiro.architecturefootball

import android.app.Application
import androidx.room.Room
import io.github.itakahiro.architecturefootball.data.db.PlayCallDatabase

class Application : Application() {
    companion object {
        lateinit var playCallDatabase: PlayCallDatabase
    }

    override fun onCreate() {
        super.onCreate()

        playCallDatabase = Room.databaseBuilder(
            applicationContext,
            PlayCallDatabase::class.java,
            "play_call_database"
        ).build()
    }
}