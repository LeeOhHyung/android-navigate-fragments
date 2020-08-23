package kr.ohyung.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kr.ohyung.data.source.UserRemoteDataSource
import kr.ohyung.remote.api.UserApi
import kr.ohyung.remote.source.UserRemoteDataSourceImpl

@Module
@InstallIn(ApplicationComponent::class)
object RemoteDataSourceModule {

    @Provides
    fun provideUserRemoteDataSource(userApi: UserApi): UserRemoteDataSource = UserRemoteDataSourceImpl(userApi)
}
