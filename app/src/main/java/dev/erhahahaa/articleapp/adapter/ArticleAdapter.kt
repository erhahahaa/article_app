package dev.erhahahaa.articleapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import dev.erhahahaa.articleapp.R
import dev.erhahahaa.articleapp.model.Article


class ArticleAdapter(
  private val articles: List<Article>,
  private val onItemClick: (Article) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

  class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(R.id.articleTitle)
    val description: TextView = view.findViewById(R.id.articleDescription)
    val cardView: CardView = view.findViewById(R.id.cardView)
    val imageView: ImageView = view.findViewById(R.id.articleImage)
    val publishedAt: TextView = view.findViewById(R.id.publishedAt)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
    return ArticleViewHolder(view)
  }

  override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
    val article = articles[position]
    holder.title.text = article.title
    holder.description.text = article.description
    Glide.with(holder.imageView.context)
      .load(article.imageResId)
      .apply(
        RequestOptions()
          .transform(CenterCrop(), RoundedCorners(32))
      )
      .into(holder.imageView)
    holder.publishedAt.text =
      holder.publishedAt.context.getString(R.string.published_at, article.publishedAt)
    holder.cardView.setOnClickListener { onItemClick(article) }
  }

  override fun getItemCount() = articles.size
}