/*
 * Created by Lee Oh Hyoung on 2020/08/05 .. 
 */
package kr.ohyung.navigation.land

internal sealed class LandingUiState {
    object Loading : LandingUiState()
    object Failed : LandingUiState()
}
