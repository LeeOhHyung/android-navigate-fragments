package kr.ohyung.navigation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kr.ohyung.common.utility.SingleLiveEvent
import kr.ohyung.common.marks.UiState
import kr.ohyung.navigation.shared.NavigationAction

abstract class BaseViewModel<State: UiState> : ViewModel() {

    abstract val uiState: MutableLiveData<State>

    val navigationAction = SingleLiveEvent<NavigationAction>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun BaseViewModel<*>.navigate(action: NavigationAction) {
        navigationAction.value = action
    }

    fun Disposable.addDisposable() = compositeDisposable.add(this)
}
