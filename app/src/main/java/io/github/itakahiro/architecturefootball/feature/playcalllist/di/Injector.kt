package io.github.itakahiro.architecturefootball.feature.playcalllist.di

import io.github.itakahiro.architecturefootball.App
import io.github.itakahiro.architecturefootball.di.RepositoryModule
import io.github.itakahiro.architecturefootball.feature.playcalllist.PlayCallListFragment

fun PlayCallListFragment.inject() {
    DaggerPlayCallListComponent.builder()
        .appComponent(App.appComponent)
        .playCallListModule(PlayCallListModule())
        .repositoryModule(RepositoryModule())
        .build()
        .inject(this)
}
