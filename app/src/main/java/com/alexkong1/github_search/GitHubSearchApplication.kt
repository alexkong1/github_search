package com.alexkong1.github_search

import android.app.Application
import com.alexkong1.github_search.data.GithubApi
import com.alexkong1.github_search.data.model.SearchUserResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubSearchApplication: Application() {

    lateinit var service: GithubApi

    override fun onCreate() {
        super.onCreate()
        initService()
    }

    private fun initService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(GithubApi::class.java)
    }

    fun getUsers(query: String): Response<SearchUserResult> {
        val search = service.searchUser(userName = query)
        return search.execute()
    }
}