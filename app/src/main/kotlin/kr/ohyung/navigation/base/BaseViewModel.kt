package kr.ohyung.navigation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kr.ohyung.navigation.shared.NavigationAction
import kr.ohyung.navigation.utility.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    val navigationAction = SingleLiveEvent<NavigationAction>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun BaseViewModel.navigate(action: NavigationAction) {
        navigationAction.value = action
    }

    fun Disposable.addDisposable() = compositeDisposable.add(this)
}
