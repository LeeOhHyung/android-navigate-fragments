/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.remote.api

import io.reactivex.Single
import kr.ohyung.remote.Api
import kr.ohyung.remote.response.UserProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi : Api {

    @GET("users/{userName}")
    fun getUserProfile(@Path("userName") userName: String): Single<UserProfileResponse>
}
