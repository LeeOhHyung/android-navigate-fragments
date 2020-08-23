/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kr.ohyung.domain.usecase.GetUserProfileUseCase
import kr.ohyung.navigation.base.BaseViewModel
import retrofit2.HttpException

internal class UserProfileViewModel @ViewModelInject constructor(
    private val getUserProfileUseCase: GetUserProfileUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel<UserProfileUiState>() {

    override val uiState = MutableLiveData<UserProfileUiState>()
    private val userName = savedStateHandle.get<String>(KEY_USER_NAME) ?: ""

    init {
        getUserProfile()
    }

    private fun getUserProfile() =
        getUserProfileUseCase.execute(userName)
            .map { response -> response.toUiState() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: DisposableSingleObserver<UserProfileUiState>() {
                override fun onSuccess(state: UserProfileUiState) {
                    uiState.value = state
                }

                override fun onError(e: Throwable) {
                    uiState.value = when (e) {
                        is HttpException -> UserProfileUiState.Failed(e.message())
                        else -> UserProfileUiState.Failed(e.message.toString())
                    }
                }
            })

    companion object {
        private const val KEY_USER_NAME = "userName"
    }
}
