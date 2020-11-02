package com.alexkong1.github_search.data

import com.alexkong1.github_search.data.model.SearchResult
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {

    @GET("search/code")
    fun searchUser(string: String): Call<SearchResult>
}