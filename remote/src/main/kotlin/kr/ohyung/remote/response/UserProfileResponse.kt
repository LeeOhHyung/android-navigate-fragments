/*
 * Created by Lee Oh Hyoung on 2020/08/06 .. 
 */
package kr.ohyung.remote.response

import kr.ohyung.domain.entity.UserProfile
import kr.ohyung.remote.Response

data class UserProfileResponse(
    val login: String,
    val id: Long,
    val node_id: String,
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
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean,
    val name: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val hireable: Boolean?,
    val bio: String?,
    val twitter_username: String?,
    val public_repos: Int,
    val public_gists: Int,
    val followers: Int,
    val following: Int,
    val created_at: String,
    val updated_at: String
) : Response

fun UserProfileResponse.toEntity() =
    UserProfile(
        id = id,
        login = login,
        avatar_url = avatar_url,
        url = url,
        html_url = html_url,
        followers_url = followers_url,
        following_url = following_url,
        gists_url = gists_url,
        starred_url = starred_url,
        subscriptions_url = subscriptions_url,
        organizations_url = organizations_url,
        repos_url = repos_url,
        name = name,
        company = company,
        blog = blog,
        location = location,
        email = email,
        bio = bio,
        public_repos = public_repos,
        public_gists = public_gists,
        followers = followers,
        following = followers
    )
