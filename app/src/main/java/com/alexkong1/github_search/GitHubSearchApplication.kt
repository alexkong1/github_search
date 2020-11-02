package com.alexkong1.github_search

import android.app.Application
import com.alexkong1.github_search.data.GithubApi
import retrofit2.Call
import retrofit2.Retrofit

class GitHubSearchApplication: Application() {

    lateinit var service: GithubApi

    override fun onCreate() {
        super.onCreate()
        initService()
    }

    private fun initService() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .build()

        service = retrofit.create(GithubApi::class.java)
    }

    fun getUsers(query: String) {
        val search = service.searchUser(userName = query)
    }
}