/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.ohyung.navigation.shared.SharedViewModel

internal class UserProfileViewModel(
    private val sharedViewModel: SharedViewModel,
    private val userName: String
) : ViewModel() {

    val uiState = MutableLiveData<UserProfileUiState>()
}
