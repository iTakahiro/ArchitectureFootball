package io.github.itakahiro.architecturefootball.di

import dagger.Module

// 1つのModuleに集約するパターン. 微妙かも. メソッドが引数を持ってしまっているから.

@Module
class AppModule {
//
//    // Dao
//    @Provides
//    fun providePlayCallDao(): PlayCallDao {
//        return App.database.playCallDao()
//    }
//
//    // Repository
//    @Provides
//    fun providePlayCallRepository(dao: PlayCallDao): PlayCallRepository {
//        return PlayCallRepository(dao)
//    }
}
