package com.alexkong1.github_search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexkong1.github_search.R
import com.alexkong1.github_search.data.model.Item

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
        recyclerView.adapter = SearchResultsAdapter(context, listOf<Item>())
    }
}