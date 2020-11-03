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
import com.alexkong1.github_search.data.model.Item
import com.alexkong1.github_search.data.model.SearchUserResult
import com.alexkong1.github_search.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

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
                GlobalScope.launch(Dispatchers.Main) {
                    try {
                        val response =
                            (context?.applicationContext as GitHubSearchApplication).getRetrofit()
                                .searchUser(s.toString())
                        Log.e("API CALL", response.toString())

                        updateRecycler(response.items)
                    } catch (e: Exception) {
                        Log.e("API CALL", "failed $e")
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("Not yet implemented")
            }
        })
    }

    private fun updateRecycler(results: List<User>) {
        if (recyclerView.adapter != null) {
            (recyclerView.adapter as SearchResultsAdapter).updateUsers(results)
        } else {
            recyclerView.adapter = SearchResultsAdapter(context, results)
        }
    }
}