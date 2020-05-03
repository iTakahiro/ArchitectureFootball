package io.github.itakahiro.architecturefootball.feature.playcalllist.di

import dagger.Module
import dagger.Provides
import io.github.itakahiro.architecturefootball.feature.playcalllist.PlayCallListViewModel
import io.github.itakahiro.architecturefootball.repository.PlayCallRepository
import javax.inject.Inject

@Module
class PlayCallListModule (
//    private val repository: PlayCallRepository
) {
    @Provides
    @Inject
    fun providePlayCallListViewModel(repository: PlayCallRepository): PlayCallListViewModel {
        return PlayCallListViewModel(repository)
    }
}
