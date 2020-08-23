package kr.ohyung.remote.source

import io.reactivex.Single
import kr.ohyung.data.source.UserRemoteDataSource
import kr.ohyung.domain.entity.UserProfile
import kr.ohyung.remote.api.UserApi
import kr.ohyung.remote.response.toEntity
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val userApi: UserApi
) : UserRemoteDataSource {

    override fun getUserProfile(userName: String): Single<UserProfile> =
        userApi.getUserProfile(userName = userName)
            .map { it.toEntity() }
}
