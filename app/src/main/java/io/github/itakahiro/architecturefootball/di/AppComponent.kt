package io.github.itakahiro.architecturefootball.di

import dagger.Component
import io.github.itakahiro.architecturefootball.feature.football.FootballFragment
import io.github.itakahiro.architecturefootball.feature.playcall.PlayCallListFragment

// Field Injection用のinjectメソッドを提供する.
// Lifecycleを持つコンポーネント(ここではFragment)にて@Injectする際にinjectメソッドを使用する

@Component(
//    modules = [AppModule::class]
    modules = [
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(fragment: FootballFragment)
    fun inject(fragment: PlayCallListFragment)
}
