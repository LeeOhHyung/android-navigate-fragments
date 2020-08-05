/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.ohyung.navigation.shared.SharedViewModel

internal class UserProfileViewModelFactory(
    private val sharedViewModel: SharedViewModel,
    private val userName: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserProfileViewModel::class.java)) {
            return UserProfileViewModel(sharedViewModel, userName) as T
        }
        throw RuntimeException("Can't create ViewModel - Unsupported Viewmodel class")
    }
}
