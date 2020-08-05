/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.api

import io.reactivex.Single
import kr.ohyung.navigation.Api
import kr.ohyung.navigation.api.response.UserProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface UserApi : Api {

    @GET("users/{userName}")
    fun getUserProfile(@Path("userName") userName: String): Single<UserProfileResponse>
}
