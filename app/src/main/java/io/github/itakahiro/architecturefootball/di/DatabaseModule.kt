package io.github.itakahiro.architecturefootball.di

import dagger.Module
import dagger.Provides
import io.github.itakahiro.architecturefootball.App
import io.github.itakahiro.architecturefootball.data.db.PlayCallDao

@Module
class DatabaseModule {

    // Dao
    @Provides
    fun providePlayCallDao(): PlayCallDao {
        return App.database.playCallDao()
    }
}
