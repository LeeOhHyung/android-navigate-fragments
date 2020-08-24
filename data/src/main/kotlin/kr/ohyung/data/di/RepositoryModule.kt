package kr.ohyung.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kr.ohyung.data.repository.UserRepositoryImpl
import kr.ohyung.data.source.UserRemoteDataSource
import kr.ohyung.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        remoteDataSource: UserRemoteDataSource
    ) : UserRepository = UserRepositoryImpl(remoteDataSource)
}
