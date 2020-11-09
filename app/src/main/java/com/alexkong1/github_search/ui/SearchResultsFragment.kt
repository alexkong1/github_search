package com.alexkong1.github_search.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexkong1.github_search.GitHubSearchApplication
import com.alexkong1.github_search.R
import com.alexkong1.github_search.data.model.User
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class SearchResultsFragment: Fragment() {

    lateinit var recyclerView: RecyclerView

    /**
     * set up runnable to show toast to user when rate limit reached
     */
    var rateLimitRunnable = Runnable {
        Toast.makeText(context,
                R.string.user_repos_error_rate_limit_exceeded,
                Toast.LENGTH_LONG)
                .show()
    }


    companion object {
        fun newInstance(): SearchResultsFragment {
            val frag = SearchResultsFragment()
            val args = Bundle()
            frag.arguments = args
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_search_results, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view)
    }

    private fun initUi(root: View) {

        recyclerView = root.findViewById(R.id.rv_search_results)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val searchBox = root.findViewById<EditText>(R.id.et_search_box)
        searchBox.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchUsers(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("Not yet implemented")
            }
        })
    }

    private fun updateRecycler(results: MutableList<User>) {
        if (recyclerView.adapter != null) {
            (recyclerView.adapter as SearchResultsAdapter).updateUsers(results)
        } else {
            recyclerView.adapter = SearchResultsAdapter(context, results)
        }
    }

    private fun searchUsers(query: String) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val response =
                    (context?.applicationContext as GitHubSearchApplication).getRetrofit()
                        .searchUser(query)
                Log.e("API CALL", response.toString())

                var newItems: Collection<User> = listOf()

                if (response.items.isNotEmpty()) {
                    try {
                        newItems = response.items.parallelMap {
                            getUserData(it)
                        }
                        Log.e("API CALL", newItems.toString())
                    } catch (e: HttpException) { }
                }
                updateRecycler(newItems.toMutableList())
            } catch (e: Exception) {
                Log.e("API CALL", "failed $e")
            }
        }
    }

    /**
     * Call user data API to get
     */
    @Throws(HttpException::class)
    private suspend fun getUserData(user: User): User {
        return try {
            val userData = (context?.applicationContext as GitHubSearchApplication).getRetrofit()
                .getUser(user.login)

            Log.e("API Call", "${userData.login}: ${userData.publicRepos}")
            userData
        } catch (e: HttpException) {
            Log.e("API Call", e.toString())
            if (e.code() == 403) {
                activity?.runOnUiThread(rateLimitRunnable)
            }
            user
            // TODO: figure out optimal delay when rate limit reached
            //throw e
        }
    }

    /**
     * concurrent fetch for additional data after initial call
     */
    private suspend fun <A, B> Collection<A>.parallelMap(
            context: CoroutineContext = Dispatchers.Default,
            block: suspend (A) -> B
    ): Collection<B> {
        return map {
            CoroutineScope(context)
                .async(context) {
                    retry(times = 3) { block(it) }
                }
        }.map {
            it.await()
        }
    }

    /**
     * retry method to attempt User fetch when rate limit exceeded.
     */
    private suspend fun <T> retry(
            times: Int = Int.MAX_VALUE,
            initialDelay: Long = 1000,
            maxDelay: Long = 5000,
            factor: Double = 2.0,
            block: suspend () -> T): T
    {
        var currentDelay = initialDelay
        repeat(times - 1) {
            try {
                return block()
            } catch (e: HttpException) { }
            delay(currentDelay)
            currentDelay = (currentDelay * factor).toLong().coerceAtMost(maxDelay)
        }
        return block()
    }

}