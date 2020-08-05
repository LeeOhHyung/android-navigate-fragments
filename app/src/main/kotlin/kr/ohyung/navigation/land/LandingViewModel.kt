/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.ohyung.navigation.shared.SharedViewModel

internal class LandingViewModel(
    private val sharedViewModel: SharedViewModel,
    private val duration: Long
) : ViewModel() {

    val uiState = MutableLiveData<LandingUiState>()

    init {
        uiState.value = LandingUiState.Loading
    }
}
