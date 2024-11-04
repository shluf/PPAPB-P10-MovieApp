package com.example.ppapb_p10_movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ppapb_p10_movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadMovies()
    }

    private fun setupRecyclerView() {
        movieAdapter = MovieAdapter { movie ->
            Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_MOVIE, movie)
                startActivity(this)
            }
        }

        binding.rvMovies.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            addItemDecoration(
                MovieItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.movie_item_spacing)
                )
            )
        }
    }

    private fun loadMovies() {
        val movies = listOf(
            Movie(
                1,
                "Venom: The Last Dance",
                "https://www.sonypictures.com/sites/default/files/styles/max_560x840/public/title-key-art/venom_onesheet_1400x2100_rated.png?itok=0tO6umMg",
                "1h 49m",
                "R13+",
                "Action",
                "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. But when Drake's latest experiment goes wrong, Eddie becomes host to the alien symbiote Venom, granting him incredible powers."
            ),
            Movie(
                2,
                "Dosa Musyrik",
                "https://unsplash.com/photos/a-bunch-of-balloons-that-are-shaped-like-email-7NT4EDSI5Ok",
                "1h 32m",
                "D17+",
                "Horror",
                "After committing an unforgivable sin, a young man is haunted by terrifying supernatural forces that reflect his inner guilt. Struggling to escape his punishment, he delves into the dark world of the occult to find redemption."
            ),
            Movie(
                3,
                "Kingdom of the Planet of the Apes",
                "https://akcdn.detik.net.id/community/media/visual/2024/01/16/film-action-terbaru-dari-hollywood-kingdom-of-the-planet-of-the-apes-2024.jpeg",
                "1h 32m",
                "D17+",
                "Action, Drama, Sci-Fi",
                "Set in a dystopian future where intelligent apes have risen to power, humanity faces extinction. Caesar's descendants grapple with both internal power struggles and external human threats, struggling to determine the fate of both species."
            ),
            Movie(
                4,
                "Fufufafa The Series",
                "https://akcdn.detik.net.id/community/media/visual/2024/01/16/film-action-terbaru-dari-hollywood-kingdom-of-the-planet-of-the-apes-2024.jpeg",
                "1h 32m",
                "D88+",
                "Action, Drama",
                "A seasoned investigator and a young rookie are forced to team up to solve a series of high-profile cases. Along the way, they confront their own personal demons and find themselves in increasingly dangerous situations."
            )
        )

        movieAdapter.submitList(movies)
    }
}