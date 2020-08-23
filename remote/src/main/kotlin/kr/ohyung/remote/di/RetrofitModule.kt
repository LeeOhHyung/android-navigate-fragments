package kr.ohyung.remote.di

import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kr.ohyung.data.BuildConfig
import kr.ohyung.remote.BuildConfig.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    private const val TAG: String = "NetworkModule"
    private const val CONNECT_TIMEOUT: Long = 30L
    private const val WRITE_TIMEOUT: Long = 30L
    private const val READ_TIMEOUT: Long = 30L

    private const val HEADER_ACCEPT = "Accept"

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggerInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(loggerInterceptor)
            .addInterceptor(headerInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideHttpLoggerInterceptor(logger: HttpLoggingInterceptor.Logger): HttpLoggingInterceptor =
        HttpLoggingInterceptor(logger)
            .apply {
                level =
                    if(BuildConfig.DEBUG)
                        HttpLoggingInterceptor.Level.BODY
                    else
                        HttpLoggingInterceptor.Level.NONE
            }

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor.Logger =
        object: HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                try {
                    JSONObject(message)
                    Logger.t(TAG).json(message)
                } catch (e: JSONException) {
                    Logger.t(TAG).d(message)
                }
            }
        }

    @Provides
    @Singleton
    fun provideHeaderIntercept(): Interceptor =
        object: Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                return with(chain.request()) {
                    newBuilder()
                        .apply {
                            header(HEADER_ACCEPT, "application/vnd.github.v3+json")
                            method(method, body)
                        }
                        .build()
                        .let { newRequest -> chain.proceed(newRequest) }
                }
            }
        }
}
