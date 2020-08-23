package kr.ohyung.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kr.ohyung.remote.api.UserApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    @Singleton
    internal fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}
