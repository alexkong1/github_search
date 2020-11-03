package com.alexkong1.github_search.data.model

data class SearchUserResult constructor(
    val total_count: Int,
    val incomplete_result: Boolean,
    val items: List<User>
)