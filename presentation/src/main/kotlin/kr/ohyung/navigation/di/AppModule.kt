package kr.ohyung.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kr.ohyung.common.utility.BaseSchedulerProvider
import kr.ohyung.navigation.utility.AppSchedulerProvider
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppSchedulerProvider(): BaseSchedulerProvider = AppSchedulerProvider()
}
