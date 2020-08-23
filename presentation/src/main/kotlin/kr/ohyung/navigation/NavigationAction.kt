/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation

import kr.ohyung.common.shared.Action

sealed class NavigationAction : Action {
    data class ToUserProfile(val userName: String) : NavigationAction()

    object Done : NavigationAction()
}
