package com.example.mvvmcleanarch.data.api

data class ArticleResponse(
    val status: String,
    val totalResults: String,
    val articles: List<Article>
)
