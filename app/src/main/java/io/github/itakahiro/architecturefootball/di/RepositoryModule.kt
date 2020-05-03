package io.github.itakahiro.architecturefootball.di

import dagger.Module
import dagger.Provides
import io.github.itakahiro.architecturefootball.data.db.PlayCallDao
import io.github.itakahiro.architecturefootball.repository.PlayCallRepository
import javax.inject.Inject

@Module(
    includes = [DatabaseModule::class]
)
class RepositoryModule {

    @Provides
    @Inject
    fun providePlayCallRepository(dao: PlayCallDao): PlayCallRepository {
        return PlayCallRepository(dao)
//        return PlayCallRepository()
    }
}
