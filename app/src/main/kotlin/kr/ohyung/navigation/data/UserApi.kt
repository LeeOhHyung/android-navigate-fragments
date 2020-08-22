/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.data

import io.reactivex.Single
import kr.ohyung.navigation.common.Api
import kr.ohyung.navigation.data.response.UserProfileResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi : Api {

    @GET("users/{userName}")
    fun getUserProfile(@Path("userName") userName: String): Single<UserProfileResponse>
}
