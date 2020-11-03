package com.alexkong1.github_search.data.model

data class User constructor(
    val login: String = "mojombo",
    val id: Int = 1,
    val node_id: String = "MDQ6VXNlcjE=",
    val avatar_url: String = "https://secure.gravatar.com/avatar/25c7c18223fb42a4c6ae1c8db6f50f9b?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
    val gravatar_id: String = "",
    val url: String = "https://api.github.com/users/mojombo",
    val html_url: String = "https://github.com/mojombo",
    val followers_url: String = "https://api.github.com/users/mojombo/followers",
    val subscriptions_url: String = "https://api.github.com/users/mojombo/subscriptions",
    val organizations_url: String = "https://api.github.com/users/mojombo/orgs",
    val repos_url: String = "https://api.github.com/users/mojombo/repos",
    val received_events_url: String = "https://api.github.com/users/mojombo/received_events",
    val type: String = "User",
    val score: Int =  1,
    val following_url: String = "https://api.github.com/users/mojombo/following{/other_user}",
    val gists_url: String = "https://api.github.com/users/mojombo/gists{/gist_id}",
    val starred_url: String = "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
    val events_url: String = "https://api.github.com/users/mojombo/events{/privacy}",
    val site_admin: Boolean =  true
) {

}