/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.splash

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kr.ohyung.navigation.base.BaseViewModel
import kr.ohyung.navigation.NavigationAction
import java.util.concurrent.TimeUnit

internal class SplashViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel<SplashUiState>() {

    override val uiState = MutableLiveData<SplashUiState>()
    private val delay = savedStateHandle.get<Long>(KEY_DURATION) ?: 0L

    init {
        uiState.value = SplashUiState.Loading
        doOnStart()
    }

    private fun doOnStart() =
        Single.timer(delay, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: DisposableSingleObserver<Long>() {
                override fun onSuccess(result: Long) {
                    navigate(NavigationAction.ToUserProfile(KEY_MY_NAME))
                }

                override fun onError(e: Throwable) {
                    uiState.value = SplashUiState.Failed
                }
            })

    companion object {
        private const val KEY_DURATION = "duration"
        private const val KEY_MY_NAME = "LeeOhHyung"
    }
}
