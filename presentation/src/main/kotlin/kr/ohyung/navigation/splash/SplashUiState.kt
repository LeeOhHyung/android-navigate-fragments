/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.splash

import kr.ohyung.common.marks.UiState

internal sealed class SplashUiState : UiState {
    object Loading : SplashUiState()
    object Failed : SplashUiState()
}
