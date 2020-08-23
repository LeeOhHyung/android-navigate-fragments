package kr.ohyung.navigation.data.repository

import io.reactivex.Single
import kr.ohyung.domain.repository.UserRepository
import kr.ohyung.navigation.data.UserApi
import kr.ohyung.navigation.data.response.toEntity
import kr.ohyung.navigation.data.entity.UserProfile
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
) : UserRepository {

    override fun getUserProfile(userName: String): Single<UserProfile> =
        userApi.getUserProfile(userName)
            .map { it.toEntity() }
}
