package com.alexkong1.github_search.data.model

data class Item constructor(
    val name: String = "classes.js",
    val path: String = "src/attributes/classes.js",
    val sha: String = "d7212f9dee2dcc18f084d7df8f417b80846ded5a",
    val url: String = "https://api.github.com/repositories/167174/contents/src/attributes/classes.js?ref=825ac3773694e0cd23ee74895fd5aeb535b27da4",
    val git_url: String = "https://api.github.com/repositories/167174/git/blobs/d7212f9dee2dcc18f084d7df8f417b80846ded5a",
    val html_url: String = "https://github.com/jquery/jquery/blob/825ac3773694e0cd23ee74895fd5aeb535b27da4/src/attributes/classes.js",
    val repository: Repository,
    val score: Int = 1
){

}