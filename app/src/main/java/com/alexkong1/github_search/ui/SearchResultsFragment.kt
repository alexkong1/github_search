package com.alexkong1.github_search.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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

    private suspend fun getUserData(user: User): User {
        return try {
            val userData = (context?.applicationContext as GitHubSearchApplication).getRetrofit()
                .getUser(user.login)

            Log.e("API Call", "${userData.login}: ${userData.publicRepos}")
            userData
        } catch (e: HttpException) {
            Log.e("API Call", e.toString())
            user
        }
    }

    suspend fun <A, B> Collection<A>.parallelMap(
            context: CoroutineContext = Dispatchers.Default,
            block: suspend (A) -> B
    ): Collection<B> {
        return map {
            // Use async to start a coroutine for each item
            CoroutineScope(context)
                .async(context) {
                    block(it)
                }
        }.map {
            // We now have a map of Deferred<T> so we await() each
            it.await()
        }
    }
}