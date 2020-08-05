/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.shared

import androidx.lifecycle.ViewModel
import kr.ohyung.navigation.BackendConfiguration
import kr.ohyung.navigation.api.RetrofitManager
import kr.ohyung.navigation.utility.SingleLiveEvent

internal class SharedViewModel(
    backendConfiguration: BackendConfiguration
) : ViewModel() {

    val retrofit = RetrofitManager.getRetrofit(backendConfiguration.baseUrl)
    val navigationAction = SingleLiveEvent<NavigationAction>()
}
