package dev.erhahahaa.articleapp.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import dev.erhahahaa.articleapp.R

class AboutActivity : AppCompatActivity() {

  private lateinit var profileImageView: ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_about)

    profileImageView = findViewById(R.id.profileImage)

    supportActionBar?.title = getString(R.string.about)
    supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    Glide.with(this)
      .load(R.drawable.rahmat_profile)
      .circleCrop()
      .into(profileImageView)
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
}