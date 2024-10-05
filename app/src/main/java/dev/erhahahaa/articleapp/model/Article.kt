package dev.erhahahaa.articleapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
  val id: Int,
  val title: String,
  val description: String,
  val content: String,
  val imageResId: Int,
  val author: String,
  val publishedAt: String
) : Parcelable