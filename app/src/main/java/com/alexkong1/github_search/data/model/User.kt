package com.alexkong1.github_search.data.model

import com.google.gson.annotations.SerializedName

data class User constructor(
    val login: String = "mojombo",
    val id: Int = 1,
    @SerializedName("node_id")
    val nodeId: String = "MDQ6VXNlcjE=",
    @SerializedName("avatar_url")
    val avatarUrl: String = "https://secure.gravatar.com/avatar/25c7c18223fb42a4c6ae1c8db6f50f9b?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
    @SerializedName("gravatar_id")
    val gravatarId: String = "",
    val url: String = "https://api.github.com/users/mojombo",
    @SerializedName("html_url")
    val htmlUrl: String = "https://github.com/mojombo",
    @SerializedName("followers_url")
    val followersUrl: String = "https://api.github.com/users/mojombo/followers",
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String = "https://api.github.com/users/mojombo/subscriptions",
    @SerializedName("organizations_url")
    val organizationsUrl: String = "https://api.github.com/users/mojombo/orgs",
    @SerializedName("repos_url")
    val reposUrl: String = "https://api.github.com/users/mojombo/repos",
    @SerializedName("received_events_url")
    val receivedEventsUrl: String = "https://api.github.com/users/mojombo/received_events",
    val type: String = "User",
    val score: Int =  1,
    @SerializedName("following_url")
    val followingUrl: String = "https://api.github.com/users/mojombo/following{/other_user}",
    @SerializedName("gists_url")
    val gistsUrl: String = "https://api.github.com/users/mojombo/gists{/gist_id}",
    @SerializedName("starred_url")
    val starredUrl: String = "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
    @SerializedName("events_url")
    val eventsUrl: String = "https://api.github.com/users/mojombo/events{/privacy}",
    @SerializedName("site_admin")
    val siteAdmin: Boolean =  true,
    @SerializedName("public_repos")
    val publicRepos: Int? = null
) {

}