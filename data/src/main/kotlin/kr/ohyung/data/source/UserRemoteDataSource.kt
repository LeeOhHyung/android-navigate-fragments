package kr.ohyung.data.source

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Single
import kr.ohyung.data.DataSource
import kr.ohyung.domain.entity.UserProfile

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface UserRemoteDataSource : DataSource {

    fun getUserProfile(userName: String): Single<UserProfile>
}
