package io.github.itakahiro.architecturefootball.feature.football.di

import io.github.itakahiro.architecturefootball.App
import io.github.itakahiro.architecturefootball.di.RepositoryModule
import io.github.itakahiro.architecturefootball.feature.football.FootballFragment

fun FootballFragment.inject() {
    DaggerFootballComponent.builder()
        .appComponent(App.appComponent)
        .footballModule(FootballModule())
        .repositoryModule(RepositoryModule())
        .build()
        .inject(this)
}