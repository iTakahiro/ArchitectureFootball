package io.github.itakahiro.architecturefootball.di

import dagger.Module
import dagger.Provides
import io.github.itakahiro.architecturefootball.feature.football.FootballViewModel
import io.github.itakahiro.architecturefootball.feature.playcall.PlayCallListViewModel
import io.github.itakahiro.architecturefootball.repository.PlayCallRepository
import javax.inject.Inject

@Module
class ViewModelModule @Inject constructor(
    private val repository: PlayCallRepository
) {

    // ViewModel
    @Provides
    fun provideFootballViewModel(): FootballViewModel {
        return FootballViewModel(repository)
    }

    @Provides
    fun providePlayCallListViewModel(): PlayCallListViewModel {
        return PlayCallListViewModel(
            repository
        )
    }
}