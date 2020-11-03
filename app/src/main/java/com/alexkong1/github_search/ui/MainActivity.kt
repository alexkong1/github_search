package com.alexkong1.github_search.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.alexkong1.github_search.GitHubSearchApplication
import com.alexkong1.github_search.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        val searchBox = findViewById<EditText>(R.id.et_search_box)
        searchBox.addTextChangedListener( object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                GlobalScope.launch(Dispatchers.Main) {
                    try {
                        var response =
                            (application as GitHubSearchApplication).getRetrofit()
                                .searchUser(s.toString())
                        Log.e("API CALL", response.toString())
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
}