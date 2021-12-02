package com.aplicativo.topikotlin.data.model

data class Lista(
    val items: ArrayList<User>
    )

data class User(
    val name: String,
    val description: String,
    val forks: String,
    val full_name: String,
    val login: String,
    val stargazers_count: String,
    val owner: Owner
    )

data class Owner(
    val avatar_url: String
    )