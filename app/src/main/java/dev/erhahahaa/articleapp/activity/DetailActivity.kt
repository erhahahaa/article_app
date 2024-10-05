package dev.erhahahaa.articleapp.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import dev.erhahahaa.articleapp.R
import dev.erhahahaa.articleapp.model.Article

class DetailActivity : AppCompatActivity() {

  private lateinit var author: TextView
  private lateinit var publishedAt: TextView
  private lateinit var contentView: TextView
  private lateinit var imageView: ImageView
  private lateinit var shareButton: Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    author = findViewById(R.id.author)
    publishedAt = findViewById(R.id.publishedAt)
    contentView = findViewById(R.id.detailContent)
    imageView = findViewById(R.id.detailImage)
    shareButton = findViewById(R.id.action_share)

    val article = if (Build.VERSION.SDK_INT >= 33) {
      intent.getParcelableExtra("article", Article::class.java)
    } else {
      @Suppress("DEPRECATION")
      intent.getParcelableExtra("article")
    }

    if (article != null) {
      author.text = application.getString(R.string.written_by, article.author)
      publishedAt.text = application.getString(R.string.published_at, article.publishedAt)
      contentView.text = article.content
      imageView.contentDescription = article.title

      Glide.with(this)
        .load(article.imageResId)
        .apply(
          RequestOptions()
            .transform(CenterCrop(), RoundedCorners(64))
        )
        .into(imageView)

      supportActionBar?.title = article.title
      supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
      supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    shareButton.setOnClickListener {
      if (article != null) {
        shareArticle(article)
      }
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      android.R.id.home -> {
        finish()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  private fun shareArticle(article: Article) {
    val shareIntent = Intent().apply {
      action = Intent.ACTION_SEND
      putExtra(Intent.EXTRA_TEXT, article.title + "\n" + article.content)
      type = "text/plain"
    }
    startActivity(Intent.createChooser(shareIntent, "Share article via"))
  }
}