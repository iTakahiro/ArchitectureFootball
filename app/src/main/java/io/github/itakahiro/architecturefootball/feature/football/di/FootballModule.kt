package io.github.itakahiro.architecturefootball.feature.football.di

import dagger.Module
import dagger.Provides
import io.github.itakahiro.architecturefootball.feature.football.FootballViewModel
import io.github.itakahiro.architecturefootball.repository.PlayCallRepository
import javax.inject.Inject

@Module

class FootballModule {

    @Provides
    @Inject
    fun provideFootballViewModel(repository: PlayCallRepository): FootballViewModel {
        return FootballViewModel(repository)
    }
}
