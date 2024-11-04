package com.example.ppapb_p10_movieapp

import android.os.Bundle
import android.os.Parcel
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

import com.example.ppapb_p10_movieapp.databinding.ActivityDetailBinding

import android.os.Parcelable


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get movie from intent extras using the new method for Parcelable
        @Suppress("DEPRECATION")
        val movie = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_MOVIE, Movie::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_MOVIE)
        }

        movie?.let { setupMovieDetail(it) }
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarContent)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarContent.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupMovieDetail(movie: Movie) {
        binding.apply {
            tvTitle.text = movie.title
            tvDuration.text = movie.duration
            tvRating.text = movie.rating
            tvGenre.text = movie.genre
            tvSynopsis.text = movie.synopsis

            Glide.with(this@DetailActivity)
                .load(movie.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.movie_placeholder)
                .into(ivPoster)
        }
    }
}