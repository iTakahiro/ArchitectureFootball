package io.github.itakahiro.architecturefootball.di

import dagger.Component

// Field Injection用のinjectメソッドを提供する.

@Component(
//    modules = [AppModule::class]
    modules = [
        DatabaseModule::class
    ]
)
interface AppComponent {

    // Daoの注入
    fun inject(module: RepositoryModule)
}
