/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kr.ohyung.navigation.api.UserApi
import kr.ohyung.navigation.shared.SharedViewModel
import retrofit2.HttpException

internal class UserProfileViewModel(
    private val userService: UserApi,
    private val sharedViewModel: SharedViewModel,
    private val userName: String
) : ViewModel() {

    val uiState = MutableLiveData<UserProfileUiState>()

    init {
        getUserProfile()
    }

    private fun getUserProfile() =
        userService.getUserProfile(userName)
            .map { response -> response.toUiState() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: DisposableSingleObserver<UserProfileUiState>() {
                override fun onSuccess(state: UserProfileUiState) {
                    uiState.value = state
                }

                override fun onError(e: Throwable) {
                    uiState.value = if(e is HttpException)
                        UserProfileUiState.Failed(e.message())
                    else
                        UserProfileUiState.Failed(e.message.toString())
                }
            })
}
