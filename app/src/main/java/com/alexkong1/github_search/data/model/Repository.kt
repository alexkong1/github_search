package com.alexkong1.github_search.data.model

data class Repository constructor(
    val id: Int = 167174,
    val node_id: String = "MDEwOlJlcG9zaXRvcnkxNjcxNzQ=",
    val name: String = "jquery",
    val full_name: String = "jquery/jquery",
    val owner: Owner,
    val private: Boolean= false,
    val html_url: String = "https://github.com/jquery/jquery",
    val description: String = "jQuery JavaScript Library",
    val fork: Boolean = false,
    val url: String = "https://api.github.com/repos/jquery/jquery",
    val forks_url: String = "https://api.github.com/repos/jquery/jquery/forks",
    val keys_url: String = "https://api.github.com/repos/jquery/jquery/keys{/key_id}",
    val collaborators_url: String = "https://api.github.com/repos/jquery/jquery/collaborators{/collaborator}",
    val teams_url: String = "https://api.github.com/repos/jquery/jquery/teams",
    val hooks_url: String = "https://api.github.com/repos/jquery/jquery/hooks",
    val issue_events_url: String = "https://api.github.com/repos/jquery/jquery/issues/events{/number}",
    val events_url: String = "https://api.github.com/repos/jquery/jquery/events",
    val assignees_url: String = "https://api.github.com/repos/jquery/jquery/assignees{/user}",
    val branches_url: String = "https://api.github.com/repos/jquery/jquery/branches{/branch}",
    val tags_url: String = "https://api.github.com/repos/jquery/jquery/tags",
    val blobs_url: String = "https://api.github.com/repos/jquery/jquery/git/blobs{/sha}",
    val git_tags_url: String = "https://api.github.com/repos/jquery/jquery/git/tags{/sha}",
    val git_refs_url: String = "https://api.github.com/repos/jquery/jquery/git/refs{/sha}",
    val trees_url: String = "https://api.github.com/repos/jquery/jquery/git/trees{/sha}",
    val statuses_url: String = "https://api.github.com/repos/jquery/jquery/statuses/{sha}",
    val languages_url: String = "https://api.github.com/repos/jquery/jquery/languages",
    val stargazers_url: String = "https://api.github.com/repos/jquery/jquery/stargazers",
    val contributors_url: String = "https://api.github.com/repos/jquery/jquery/contributors",
    val subscribers_url: String = "https://api.github.com/repos/jquery/jquery/subscribers",
    val subscription_url: String = "https://api.github.com/repos/jquery/jquery/subscription",
    val commits_url: String = "https://api.github.com/repos/jquery/jquery/commits{/sha}",
    val git_commits_url: String = "https://api.github.com/repos/jquery/jquery/git/commits{/sha}",
    val comments_url: String = "https://api.github.com/repos/jquery/jquery/comments{/number}",
    val issue_comment_url: String = "https://api.github.com/repos/jquery/jquery/issues/comments/{number}",
    val contents_url: String = "https://api.github.com/repos/jquery/jquery/contents/{+path}",
    val compare_url: String = "https://api.github.com/repos/jquery/jquery/compare/{base}...{head}",
    val merges_url: String = "https://api.github.com/repos/jquery/jquery/merges",
    val archive_url: String = "https://api.github.com/repos/jquery/jquery/{archive_format}{/ref}",
    val downloads_url: String = "https://api.github.com/repos/jquery/jquery/downloads",
    val issues_url: String = "https://api.github.com/repos/jquery/jquery/issues{/number}",
    val pulls_url: String = "https://api.github.com/repos/jquery/jquery/pulls{/number}",
    val milestones_url: String = "https://api.github.com/repos/jquery/jquery/milestones{/number}",
    val notifications_url: String = "https://api.github.com/repos/jquery/jquery/notifications{?since,all,participating}",
    val labels_url: String = "https://api.github.com/repos/jquery/jquery/labels{/name}",
    val deployments_url: String = "http://api.github.com/repos/octocat/Hello-World/deployments",
    val releases_url: String = "http://api.github.com/repos/octocat/Hello-World/releases{/id}"
) {

}