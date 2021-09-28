package com.example.mvvmcleanarch.util

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mvvmcleanarch.data.api.Article
import com.example.mvvmcleanarch.databinding.ItensNewScreenBinding
import com.squareup.picasso.Picasso

class ArticlesAdapter(private val articles: List<Article>, private val context: Context) : Adapter<ArticlesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItensNewScreenBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.newsText.text = article.title
            binding.description.text = article.description
            binding.newsSource.text = article.source.name
            Picasso.get().load(article.urlToImage).into(binding.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItensNewScreenBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}