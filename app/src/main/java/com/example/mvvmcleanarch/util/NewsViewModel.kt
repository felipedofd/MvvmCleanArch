package com.example.mvvmcleanarch.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcleanarch.data.api.ArticleResponse
import com.example.mvvmcleanarch.data.api.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewModel : ViewModel() {
    val news = MutableLiveData<ArticleResponse>()
    private val newsApi = RetrofitInitializer.newsApi()

    fun buscarNews(busca: String) {

        val result = newsApi.getNews(busca, "ae68700d7dad43d0bc90bda8e85caa12").enqueue(object : Callback<ArticleResponse> {
            override fun onResponse(call: Call<ArticleResponse>, response: Response<ArticleResponse>) {

                news.postValue(response.body())

            }

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                print(t.toString())
            }
        })
    }
}