/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.ohyung.navigation.BackendConfiguration

internal class SharedViewModelFactory(
    private val backendConfiguration: BackendConfiguration
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel(backendConfiguration) as T
        }
        throw RuntimeException("Can't create ViewModel - Unsupported Viewmodel class")
    }
}
