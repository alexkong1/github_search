package com.alexkong1.github_search.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexkong1.github_search.R
import com.alexkong1.github_search.data.model.User
import com.bumptech.glide.Glide

class SearchResultsAdapter constructor(
    private val context: Context?,
    private var users: MutableList<User>):
    RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {

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

    fun updateUsers(results: MutableList<User>) {
        users = results
        notifyDataSetChanged()
    }

    inner class ViewHolder constructor(view: View): RecyclerView.ViewHolder(view) {
        fun onBind(user: User) {
            itemView.findViewById<TextView>(R.id.tv_search_result_username).text = user.login
            if (user.publicRepos != null)
                itemView.findViewById<TextView>(R.id.tv_search_result_public_repos).text =
                        context?.getString(R.string.user_repos, user.publicRepos)

            Glide.with(itemView)
                .load(user.avatarUrl)
                .into(itemView.findViewById(R.id.iv_search_result_avatar))
        }
    }
}