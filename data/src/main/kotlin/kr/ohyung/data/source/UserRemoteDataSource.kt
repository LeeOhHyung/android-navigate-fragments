package kr.ohyung.data.source

import io.reactivex.Single
import kr.ohyung.data.DataSource
import kr.ohyung.domain.entity.UserProfile

interface UserRemoteDataSource : DataSource {
    fun getUserProfile(userName: String): Single<UserProfile>
}
