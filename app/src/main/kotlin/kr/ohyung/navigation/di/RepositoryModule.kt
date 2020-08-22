package kr.ohyung.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kr.ohyung.navigation.data.UserApi
import kr.ohyung.navigation.data.repository.UserRepository
import kr.ohyung.navigation.data.repository.UserRepositoryImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideUserRepository(userApi: UserApi) : UserRepository = UserRepositoryImpl(userApi)
}
