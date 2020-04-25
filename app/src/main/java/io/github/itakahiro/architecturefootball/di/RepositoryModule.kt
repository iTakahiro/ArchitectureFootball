package io.github.itakahiro.architecturefootball.di

import dagger.Module
import dagger.Provides
import io.github.itakahiro.architecturefootball.data.db.PlayCallDao
import io.github.itakahiro.architecturefootball.repository.PlayCallRepository
import javax.inject.Inject

@Module
class RepositoryModule @Inject constructor(
    private val dao: PlayCallDao
) {
    // Repository
    @Provides
    fun providePlayCallRepository(): PlayCallRepository {
        return PlayCallRepository(dao)
    }
}