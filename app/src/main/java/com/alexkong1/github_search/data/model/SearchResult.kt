package com.alexkong1.github_search.data.model

data class SearchResult constructor(
    val totalCount: Int,
    val incompleteResult: Boolean,
    val items: Array<User>
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SearchResult

        if (totalCount != other.totalCount) return false
        if (incompleteResult != other.incompleteResult) return false
        if (!items.contentEquals(other.items)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = totalCount
        result = 31 * result + incompleteResult.hashCode()
        result = 31 * result + items.contentHashCode()
        return result
    }

}