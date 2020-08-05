/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.shared

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

internal class SharedViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel() as T
        }
        throw RuntimeException("Can't create ViewModel - Unsupported Viewmodel class")
    }
}
