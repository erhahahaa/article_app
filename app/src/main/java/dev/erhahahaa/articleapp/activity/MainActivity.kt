package dev.erhahahaa.articleapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.erhahahaa.articleapp.R
import dev.erhahahaa.articleapp.adapter.ArticleAdapter
import dev.erhahahaa.articleapp.model.Article

class MainActivity : AppCompatActivity() {

  private lateinit var recyclerView: RecyclerView
  private lateinit var articleAdapter: ArticleAdapter
  private lateinit var articles: List<Article>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recyclerView = findViewById(R.id.rvArticles)

    articles = getArticles()
    articleAdapter = ArticleAdapter(articles) { article ->
      val intent = Intent(this, DetailActivity::class.java)
      intent.putExtra("article", article)
      startActivity(intent)
    }

    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = articleAdapter
  }


  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_main, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.about_page -> {
        startActivity(Intent(this, AboutActivity::class.java))
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }


  private fun getArticles(): List<Article> {
    return listOf(
      Article(1, "The Rise of Electric Vehicles", "An overview of the increasing adoption of electric vehicles.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "John Doe", "2024-10-01"),
      Article(2, "Climate Change and Its Impacts", "Exploring the effects of climate change on our planet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Jane Smith", "2024-10-02"),
      Article(3, "Artificial Intelligence: The Future", "How AI is shaping the future of technology and society.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Alice Johnson", "2024-10-03"),
      Article(4, "Health Benefits of Meditation", "Understanding the mental and physical benefits of meditation.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Bob Brown", "2024-10-04"),
      Article(5, "The Importance of Cybersecurity", "Why cybersecurity is vital in today's digital world.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Emily Davis", "2024-10-05"),
      Article(6, "Exploring Space: New Discoveries", "Recent findings in the field of space exploration.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Michael Wilson", "2024-10-06"),
      Article(7, "The Evolution of Social Media", "How social media has transformed communication.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Sarah Taylor", "2024-10-07"),
      Article(8, "Renewable Energy: The Way Forward", "A look into renewable energy sources and their future.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "David Lee", "2024-10-08"),
      Article(9, "The Future of Work: Remote vs. In-Office", "Analyzing the shift towards remote work and its implications.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Linda Clark", "2024-10-09"),
      Article(10, "Globalization: Benefits and Challenges", "Understanding the impacts of globalization on economies.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Kevin Wright", "2024-10-10"),
      Article(11, "Mental Health Awareness", "The significance of mental health in today's society.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Laura Scott", "2024-10-11"),
      Article(12, "Sustainable Agriculture Practices", "Innovative practices for sustainable farming.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "George King", "2024-10-12"),
      Article(13, "The Role of Technology in Education", "How technology is transforming the education sector.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Megan Young", "2024-10-13"),
      Article(14, "Wildlife Conservation Efforts", "Efforts being made to protect endangered species.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Steven Green", "2024-10-14"),
      Article(15, "The Impact of 5G Technology", "How 5G technology is changing the telecommunications landscape.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.dome, "Nancy Adams", "2024-10-15")
    )
  }

}
