package kr.ohyung.navigation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kr.ohyung.common.shared.Action
import kr.ohyung.common.utility.SingleLiveEvent
import kr.ohyung.common.shared.UiState

abstract class BaseViewModel<State: UiState> : ViewModel() {

    abstract val uiState: MutableLiveData<State>

    val navigationAction = SingleLiveEvent<Action>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun BaseViewModel<*>.navigate(action: Action) {
        navigationAction.value = action
    }

    fun Disposable.addDisposable() = compositeDisposable.add(this)
}
