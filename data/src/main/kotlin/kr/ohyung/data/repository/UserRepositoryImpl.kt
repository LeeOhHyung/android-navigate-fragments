package kr.ohyung.data.repository

import io.reactivex.Single
import kr.ohyung.data.source.UserRemoteDataSource
import kr.ohyung.domain.entity.UserProfile
import kr.ohyung.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remote: UserRemoteDataSource
) : UserRepository {

    override fun getUserProfile(userName: String): Single<UserProfile> =
        remote.getUserProfile(userName)
}
