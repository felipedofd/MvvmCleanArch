package com.example.mvvmcleanarch.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun newsApi(): NewsApi {
        return retrofit.create(NewsApi::class.java)

    }

}