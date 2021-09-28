package com.example.mvvmcleanarch.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/everything")

    fun getNews(
        @Query("q") busca: String,
        @Query("apiKey") apiKey: String

    ): Call<ArticleResponse>

}