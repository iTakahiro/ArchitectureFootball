package io.github.itakahiro.architecturefootball.feature.playcalllist.di

import dagger.Component
import io.github.itakahiro.architecturefootball.di.AppComponent
import io.github.itakahiro.architecturefootball.di.RepositoryModule
import io.github.itakahiro.architecturefootball.feature.playcalllist.PlayCallListFragment

@Component(
    modules = [
        PlayCallListModule::class,
        RepositoryModule::class
    ],
    dependencies = [AppComponent::class]
)
interface PlayCallListComponent {
    fun inject(fragment: PlayCallListFragment)

    @Component.Builder
    interface Builder {
        fun build(): PlayCallListComponent
        fun appComponent(component: AppComponent): Builder
        fun playCallListModule(module: PlayCallListModule): Builder
        fun repositoryModule(module: RepositoryModule): Builder
    }
}
