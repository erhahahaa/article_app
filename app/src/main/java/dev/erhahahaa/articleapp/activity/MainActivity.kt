package dev.erhahahaa.articleapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.erhahahaa.articleapp.R
import dev.erhahahaa.articleapp.adapter.ArticleAdapter
import dev.erhahahaa.articleapp.model.Article
import dev.erhahahaa.articleapp.setDefaultAppBarColor

class MainActivity : AppCompatActivity() {

  private lateinit var recyclerView: RecyclerView
  private lateinit var articleAdapter: ArticleAdapter
  private lateinit var articles: List<Article>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setDefaultAppBarColor(supportActionBar, window, resources, theme)

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
      Article(
        1,
        "The Rise of Electric Vehicles",
        "An overview of the increasing adoption of electric vehicles.",
        "The rise of electric vehicles (EVs) marks a significant shift in the automotive industry. As concerns about climate change and fossil fuel dependence grow, more consumers and manufacturers are embracing electric mobility. Advances in battery technology have improved EV range and affordability, making them a viable alternative to traditional gasoline-powered cars. Governments worldwide are incentivizing EV adoption through subsidies and infrastructure development, such as charging stations. This transition not only reduces greenhouse gas emissions but also paves the way for innovations in sustainable transportation solutions, contributing to a cleaner and greener future.",
        R.drawable.ev,
        "John Doe",
        "2024-10-01"
      ),
      Article(
        2,
        "Climate Change and Its Impacts",
        "Exploring the effects of climate change on our planet.",
        "Climate change poses one of the most significant challenges of our time, driven by human activities such as deforestation, industrialization, and fossil fuel consumption. Its impacts are pervasive, leading to extreme weather events, rising sea levels, and shifting ecosystems. Communities worldwide are experiencing more frequent and intense storms, droughts, and floods, threatening food security and public health. Vulnerable populations are disproportionately affected, exacerbating social inequalities. To mitigate these effects, global cooperation is essential, emphasizing sustainable practices and policies that prioritize environmental conservation and the reduction of carbon emission.",
        R.drawable.climate,
        "Jane Smith",
        "2024-10-02"
      ),
      Article(
        3,
        "Artificial Intelligence: The Future",
        "How AI is shaping the future of technology and society.",
        "Artificial Intelligence (AI) represents a transformative technology shaping the future across various sectors. From healthcare to finance, AI enhances efficiency and accuracy by automating processes and analyzing vast amounts of data. Machine learning algorithms improve decision-making, enabling personalized experiences and innovative solutions. However, as AI systems become increasingly integrated into society, ethical considerations arise, including privacy concerns and the potential for job displacement. Ensuring responsible AI development and implementation is crucial to harness its benefits while addressing societal challenges, ultimately leading to a future where humans and machines collaborate harmoniously.",
        R.drawable.ai,
        "Alice Johnson",
        "2024-10-03"
      ),
      Article(
        4,
        "Health Benefits of Meditation",
        "Understanding the mental and physical benefits of meditation.",
        "Meditation has gained recognition for its numerous health benefits, promoting mental clarity, emotional stability, and physical well-being. Regular practice can reduce stress, anxiety, and depression, enhancing overall quality of life. Studies show that meditation fosters mindfulness, helping individuals remain present and improve their emotional responses to daily challenges. Additionally, meditation supports cognitive functions and boosts creativity, making it a valuable tool for personal and professional growth. By incorporating meditation into daily routines, individuals can cultivate a sense of peace, resilience, and greater self-awareness, contributing to healthier lifestyles.",
        R.drawable.meditation,
        "Bob Brown",
        "2024-10-04"
      ),
      Article(
        5,
        "The Importance of Cybersecurity",
        "Why cybersecurity is vital in today's digital world.",
        "In today’s digital age, cybersecurity has become paramount as businesses and individuals increasingly rely on technology. Cyber threats, including data breaches, ransomware attacks, and identity theft, pose significant risks to sensitive information and financial stability. Effective cybersecurity measures protect against unauthorized access and safeguard personal and organizational data. As cybercriminals become more sophisticated, the demand for skilled cybersecurity professionals is rising. Education and awareness are essential in fostering a culture of security, empowering individuals to recognize potential threats and adopt safe online practices, ultimately creating a more secure digital environment.",
        R.drawable.cyber_security,
        "Emily Davis",
        "2024-10-05"
      ),
      Article(
        6,
        "Exploring Space: New Discoveries",
        "Recent findings in the field of space exploration.",
        "The exploration of space has captivated humanity's imagination for decades, leading to groundbreaking discoveries that expand our understanding of the universe. Recent advancements in technology have facilitated missions to Mars, the Moon, and beyond, uncovering the potential for life beyond Earth and revealing the complexities of our solar system. Telescopes and satellites provide insights into distant galaxies, while space probes gather data about planetary atmospheres and compositions. These discoveries inspire scientific innovation and collaboration, fostering international partnerships in space exploration that aim to unlock the mysteries of the cosmos and advance our knowledge of existence.",
        R.drawable.space,
        "Michael Wilson",
        "2024-10-06"
      ),
      Article(
        7,
        "The Evolution of Social Media",
        "How social media has transformed communication.",
        "Social media has transformed how people communicate, share information, and interact globally. From its humble beginnings with platforms like Friendster and MySpace to the dominance of giants like Facebook, Instagram, and Twitter, social media has evolved rapidly. It fosters connections, enabling users to share experiences and ideas instantaneously. However, the rise of social media also presents challenges, including misinformation, cyberbullying, and privacy concerns. Balancing the benefits of connectivity with the need for responsible usage is crucial as social media continues to shape societal norms, influence politics, and redefine relationships.",
        R.drawable.social_media,
        "Sarah Taylor",
        "2024-10-07"
      ),
      Article(
        8,
        "Renewable Energy: The Way Forward",
        "A look into renewable energy sources and their future.",
        "Renewable energy sources, including solar, wind, and hydropower, are crucial in combating climate change and reducing reliance on fossil fuels. As technology advances, the efficiency and affordability of renewable energy systems have improved significantly, making them more accessible for individuals and businesses. Governments worldwide are increasingly investing in renewable energy projects and infrastructure, promoting sustainability and environmental stewardship. Transitioning to renewable energy not only mitigates greenhouse gas emissions but also stimulates economic growth by creating green jobs and fostering innovation, positioning the world toward a more sustainable and resilient future.",
        R.drawable.energy,
        "David Lee",
        "2024-10-08"
      ),
      Article(
        9,
        "The Future of Work: Remote vs. In-Office",
        "Analyzing the shift towards remote work and its implications.",
        "The future of work is evolving rapidly, with the COVID-19 pandemic accelerating trends toward remote work. Many organizations are now adopting hybrid models, allowing employees to choose between working from home and in-office settings. This shift offers flexibility and improved work-life balance but also presents challenges, such as maintaining team cohesion and effective communication. As technology continues to facilitate remote collaboration, the focus on results-driven performance rather than traditional office hours is likely to reshape workplace culture. The future will see organizations balancing flexibility with the benefits of in-person collaboration.",
        R.drawable.workspace,
        "Linda Clark",
        "2024-10-09"
      ),
      Article(
        10,
        "Globalization: Benefits and Challenges",
        "Understanding the impacts of globalization on economies.",
        "Globalization has interconnected economies, cultures, and societies, fostering economic growth and cultural exchange. It enables businesses to reach broader markets and consumers access diverse products and services. However, globalization also presents challenges, including income inequality, job displacement, and cultural homogenization. The impact of globalization varies across regions, with some benefiting significantly while others face adverse effects. Addressing these disparities requires collaborative efforts from governments, businesses, and communities to create fair policies and practices that promote sustainable development and ensure the benefits of globalization are shared equitably.",
        R.drawable.globalization,
        "Kevin Wright",
        "2024-10-10"
      ),
      Article(
        11,
        "Mental Health Awareness",
        "The significance of mental health in today's society.",
        "Mental health awareness is increasingly recognized as essential to overall well-being. Stigma surrounding mental health issues often prevents individuals from seeking help, leading to untreated conditions and deteriorating quality of life. Promoting mental health awareness encourages open discussions, reducing stigma and fostering understanding. Education on mental health resources and support systems is crucial for empowering individuals to prioritize their mental well-being. Community initiatives, workplace programs, and public campaigns play vital roles in creating supportive environments where mental health is valued, ensuring individuals have access to necessary care and fostering resilience.",
        R.drawable.mental_health,
        "Laura Scott",
        "2024-10-11"
      ),
      Article(
        12,
        "Sustainable Agriculture Practices",
        "Innovative practices for sustainable farming.",
        "Sustainable agriculture practices are vital for ensuring food security while minimizing environmental impact. These practices include crop rotation, organic farming, and integrated pest management, promoting biodiversity and soil health. By utilizing sustainable methods, farmers can reduce reliance on synthetic chemicals, conserve water, and mitigate climate change effects. Additionally, sustainable agriculture supports local economies and fosters community resilience by encouraging consumers to buy locally produced food. As global populations continue to grow, adopting sustainable agricultural practices is essential for fostering a healthy planet, supporting livelihoods, and ensuring future generations have access to nutritious food.",
        R.drawable.agriculture,
        "George King",
        "2024-10-12"
      ),
      Article(
        13,
        "The Role of Technology in Education",
        "How technology is transforming the education sector.",
        "Technology plays a transformative role in education, enhancing teaching and learning experiences. Digital tools, online resources, and educational software provide innovative ways to engage students and facilitate personalized learning. Technology enables remote learning, expanding access to education for individuals regardless of location. It supports diverse learning styles and allows for interactive and collaborative activities. However, the digital divide poses challenges, as not all students have equal access to technology. Addressing these disparities is crucial to ensure equitable education opportunities, allowing all learners to benefit from technological advancements.",
        R.drawable.edu_tech,
        "Megan Young",
        "2024-10-13"
      ),
      Article(
        14,
        "Wildlife Conservation Efforts",
        "Efforts being made to protect endangered species.",
        "Wildlife conservation efforts are crucial in protecting endangered species and preserving biodiversity. Habitat loss, poaching, and climate change threaten wildlife populations worldwide, leading to drastic declines in various species. Conservation organizations work tirelessly to implement protective measures, restore habitats, and raise awareness about the importance of biodiversity. Community involvement and education play essential roles in successful conservation initiatives, fostering a sense of responsibility toward protecting wildlife. By promoting sustainable practices and encouraging ethical tourism, we can ensure the survival of wildlife and maintain the health of our ecosystems for future generations.",
        R.drawable.wildlife,
        "Steven Green",
        "2024-10-14"
      ),
      Article(
        15,
        "The Impact of 5G Technology",
        "How 5G technology is changing the telecommunications landscape.",
        "The rollout of 5G technology promises to revolutionize communication and connectivity. With significantly faster data transfer speeds and lower latency, 5G enables seamless streaming, real-time communication, and enhanced mobile experiences. This advancement supports the growth of smart cities, IoT devices, and autonomous vehicles, transforming various industries. However, the implementation of 5G also raises concerns about privacy, security, and health effects. As the technology evolves, addressing these issues is crucial to ensure that the benefits of 5G are realized while mitigating potential risks, ultimately paving the way for a more connected and efficient future.",
        R.drawable.five_g,
        "Nancy Adams",
        "2024-10-15"
      )
    )
  }

}
