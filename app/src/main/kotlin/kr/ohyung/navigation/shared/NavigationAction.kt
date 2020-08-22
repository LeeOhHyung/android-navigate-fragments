/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.shared

sealed class NavigationAction {
    data class ToUserProfile(val userName: String) : NavigationAction()

    object Done : NavigationAction()
}
