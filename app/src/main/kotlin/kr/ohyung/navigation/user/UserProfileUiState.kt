/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.navigation.user

import kr.ohyung.navigation.common.UiState
import kr.ohyung.navigation.data.entity.UserProfile

internal sealed class UserProfileUiState : UiState {

    object Loading : UserProfileUiState()
    data class UserProfile(
        val userName: String,
        val company: String,
        val blog: String,
        val email: String,
        val bio: String,
        val avatarUrl: String,
        val followersCount: Int,
        val followingCount: Int,
        val publicRepoCount: Int
    ) : UserProfileUiState()

    data class Failed(
        val errorMessage: String
    ) : UserProfileUiState()
}

internal fun UserProfile.toUiState() =
    UserProfileUiState.UserProfile(
        userName = login,
        company = company ?: "",
        blog = blog ?: "",
        email = email ?: "",
        bio = bio ?: "",
        avatarUrl = avatar_url,
        followersCount = followers,
        followingCount = following,
        publicRepoCount = public_repos
    )
