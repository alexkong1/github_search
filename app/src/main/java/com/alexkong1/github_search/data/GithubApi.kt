package com.alexkong1.github_search.data

import com.alexkong1.github_search.data.model.SearchUserResult
import com.alexkong1.github_search.data.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("search/users")
    suspend fun searchUser(
        @Query("q", encoded = false) userName: String?
    ): SearchUserResult

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("users/{username}")
    suspend fun getUser(
        @Path("username") userName: String?
    ): User
}