/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.ohyung.navigation.shared.SharedViewModel

internal class LandingViewModelFactory(
    private val sharedViewModel: SharedViewModel,
    private val duration: Long
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LandingViewModel::class.java)) {
            return LandingViewModel(sharedViewModel, duration) as T
        }
        throw RuntimeException("Can't create ViewModel - Unsupported Viewmodel class")
    }
}
