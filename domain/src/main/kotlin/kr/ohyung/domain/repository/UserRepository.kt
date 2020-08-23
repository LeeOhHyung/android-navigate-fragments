package kr.ohyung.domain.repository

import io.reactivex.Single
import kr.ohyung.domain.Repository
import kr.ohyung.domain.entity.UserProfile

interface UserRepository : Repository {

    fun getUserProfile(userName: String): Single<UserProfile>
}
