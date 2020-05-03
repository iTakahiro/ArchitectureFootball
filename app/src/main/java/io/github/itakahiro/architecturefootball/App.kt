package io.github.itakahiro.architecturefootball

import android.app.Application
import androidx.room.Room
import io.github.itakahiro.architecturefootball.data.db.AppDatabase
import io.github.itakahiro.architecturefootball.di.AppComponent
import io.github.itakahiro.architecturefootball.di.DaggerAppComponent
import io.github.itakahiro.architecturefootball.di.DatabaseModule

class App : Application() {
    companion object {
        lateinit var database: AppDatabase
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule())
            .build()
    }
}
