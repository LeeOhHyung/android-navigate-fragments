package kr.ohyung.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ohyung.navigation.BackendConfiguration
import kr.ohyung.navigation.BuildConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonComponentModule {

    @Provides
    @Singleton
    internal fun provideBackendConfiguration(): BackendConfiguration =
        BackendConfiguration(BuildConfig.BASE_URL)
}
