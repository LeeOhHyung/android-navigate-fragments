package kr.ohyung.navigation.data.entity

import kr.ohyung.navigation.common.Entity

data class UserProfile(
    val id: Long,
    val login: String,
    val avatar_url: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val name: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int
): Entity
