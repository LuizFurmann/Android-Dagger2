package com.aplicativo.topikotlin.model

data class User(
    val name: String,
    val description: String,
    val forks: String,
    val full_name: String,
    val login: String,
    val stargazers_count: String,
    val owner: Owner
)
