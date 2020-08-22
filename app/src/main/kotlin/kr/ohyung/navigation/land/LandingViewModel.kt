/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kr.ohyung.navigation.base.BaseViewModel
import kr.ohyung.navigation.shared.NavigationAction
import java.util.concurrent.TimeUnit

internal class LandingViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    override val uiState = MutableLiveData<LandingUiState>()

    init {
        uiState.value = LandingUiState.Loading
        doOnStart()
    }

    private fun doOnStart() =
        Single.timer(savedStateHandle.get<Long>(KEY_DURATION) ?: 0L, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: DisposableSingleObserver<Long>() {
                override fun onSuccess(result: Long) {
                    navigate(NavigationAction.ToUserProfile("LeeOhHyung"))
                }

                override fun onError(e: Throwable) {
                    uiState.value = LandingUiState.Failed
                }
            })

    companion object {
        private const val KEY_DURATION = "duration"
    }
}
