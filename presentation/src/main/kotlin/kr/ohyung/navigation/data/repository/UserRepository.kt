package kr.ohyung.navigation.data.repository

import io.reactivex.Single
import kr.ohyung.common.marks.Repository
import kr.ohyung.navigation.data.entity.UserProfile

interface UserRepository : Repository {

    fun getUserProfile(userName: String): Single<UserProfile>
}
