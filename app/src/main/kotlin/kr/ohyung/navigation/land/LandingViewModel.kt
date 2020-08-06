/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kr.ohyung.navigation.shared.NavigationAction
import kr.ohyung.navigation.shared.SharedViewModel
import java.util.concurrent.TimeUnit

internal class LandingViewModel(
    private val sharedViewModel: SharedViewModel,
    private val duration: Long
) : ViewModel() {

    val uiState = MutableLiveData<LandingUiState>()

    init {
        uiState.value = LandingUiState.Loading
        doOnStart()
    }

    private fun doOnStart() =
        Single.timer(duration, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: DisposableSingleObserver<Long>() {
                override fun onSuccess(result: Long) {
                    val userName = "LeeOhHyung"
                    sharedViewModel.navigationAction.value = NavigationAction.ToUserProfile(userName)
                }

                override fun onError(e: Throwable) {
                    uiState.value = LandingUiState.Failed
                }
            })
}
