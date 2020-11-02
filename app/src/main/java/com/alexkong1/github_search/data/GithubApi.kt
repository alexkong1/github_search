package com.alexkong1.github_search.data

import com.alexkong1.github_search.data.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GithubApi {

    @GET("search/code")
    fun searchUser(
        @Header("accept") contentType: String = "application/vnd.github.v3+json",
        @Query("q", encoded = false) userName: String?
    ): Call<SearchResult>
}