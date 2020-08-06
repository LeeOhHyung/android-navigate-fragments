/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        with(chain.request()) {
            newBuilder()
                .apply {
                    header(HEADER_ACCEPT, "application/vnd.github.v3+json")
                    method(method, body)
                }
                .build()
                .let { newRequest ->
                    chain.proceed(newRequest)
                }
        }

    companion object {
        private const val HEADER_ACCEPT = "Accept"
    }
}
