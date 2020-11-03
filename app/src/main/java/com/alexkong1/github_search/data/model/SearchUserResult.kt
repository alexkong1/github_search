package com.alexkong1.github_search.data.model

data class SearchUserResult constructor(
    val total_count: Int,
    val incomplete_result: Boolean,
    val items: Array<User>
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SearchUserResult

        if (total_count != other.total_count) return false
        if (incomplete_result != other.incomplete_result) return false
        if (!items.contentEquals(other.items)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = total_count
        result = 31 * result + incomplete_result.hashCode()
        result = 31 * result + items.contentHashCode()
        return result
    }

}