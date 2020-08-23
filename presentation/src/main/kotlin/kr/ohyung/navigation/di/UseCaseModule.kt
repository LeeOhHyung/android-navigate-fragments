package kr.ohyung.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kr.ohyung.common.utility.BaseSchedulerProvider
import kr.ohyung.domain.repository.UserRepository
import kr.ohyung.domain.usecase.GetUserProfileUseCase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserProfileUseCase(
        userRepository: UserRepository,
        baseSchedulerProvider: BaseSchedulerProvider
    ) = GetUserProfileUseCase(
        userRepository,
        baseSchedulerProvider.io(),
        baseSchedulerProvider.mainThread()
    )
}
