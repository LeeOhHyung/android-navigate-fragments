/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

import kr.ohyung.navigation.UiState

internal sealed class LandingUiState : UiState {
    object Loading : LandingUiState()
    object Failed : LandingUiState()
}
