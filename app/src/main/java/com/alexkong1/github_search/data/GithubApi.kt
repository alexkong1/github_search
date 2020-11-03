package com.alexkong1.github_search.data

import com.alexkong1.github_search.data.model.SearchUserResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubApi {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("search/users")
    suspend fun searchUser(
        @Query("q", encoded = false) userName: String?
    ): SearchUserResult
}