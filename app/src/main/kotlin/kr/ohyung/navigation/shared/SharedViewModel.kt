/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.shared

import androidx.lifecycle.ViewModel
import kr.ohyung.navigation.SingleLiveEvent

internal class SharedViewModel : ViewModel() {

    val navigationAction = SingleLiveEvent<NavigationAction>()
}
