package com.alexkong1.github_search.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexkong1.github_search.R
import com.alexkong1.github_search.data.model.User

class SearchResultsAdapter(private val context: Context?, private var users: List<User>): RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return ViewHolder(inflater.inflate(R.layout.item_search_result, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun updateUsers(results: List<User>) {
        users = results
        notifyDataSetChanged()
    }

    class ViewHolder constructor(view: View): RecyclerView.ViewHolder(view) {
        fun onBind(user: User) {
            itemView.findViewById<TextView>(R.id.tv_search_result_username).text = user.login
        }
    }
}