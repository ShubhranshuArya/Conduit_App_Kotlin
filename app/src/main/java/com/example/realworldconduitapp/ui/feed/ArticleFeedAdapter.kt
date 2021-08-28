package com.example.realworldconduitapp.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ListAdapter
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.api.models.entities.Article
import com.example.realworldconduitapp.R
import com.example.realworldconduitapp.databinding.ListItemArticleBinding
import java.text.FieldPosition

class ArticleFeedAdapter : androidx.recyclerview.widget.ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
    object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }
){

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            parent.context.getSystemService(
                LayoutInflater::class.java
            ).inflate(
                R.layout.list_item_article,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        ListItemArticleBinding.bind(holder.itemView).apply {
            val article = getItem(position)

            textViewAuthor.text = article.author.username
            textViewTitle.text = article.title
            textViewDescription.text = article.description
        }
    }






}