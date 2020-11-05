package com.alexkong1.github_search.data.model

import com.google.gson.annotations.SerializedName

data class SearchUserResult constructor(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_result")
    val incompleteResult: Boolean,
    val items: List<User>
)