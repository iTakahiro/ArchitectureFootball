package io.github.itakahiro.architecturefootball.feature.football.di

import dagger.Component
import io.github.itakahiro.architecturefootball.di.AppComponent
import io.github.itakahiro.architecturefootball.di.RepositoryModule
import io.github.itakahiro.architecturefootball.feature.football.FootballFragment

@Component(
    modules = [
        FootballModule::class,
        RepositoryModule::class
    ],
    dependencies = [AppComponent::class]
)
interface FootballComponent {
    fun inject(fragment: FootballFragment)

    @Component.Builder
    interface Builder {
        fun build(): FootballComponent
        fun appComponent(component: AppComponent): Builder
        fun footballModule(module: FootballModule): Builder
        fun repositoryModule(module: RepositoryModule): Builder
    }
}