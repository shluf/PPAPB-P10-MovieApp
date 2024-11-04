import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ppapb_p10_movieapp.Movie
import com.example.ppapb_p10_movieapp.R
import com.example.ppapb_p10_movieapp.databinding.ItemMovieCardBinding

class MovieViewHolder(private val binding: ItemMovieCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, onItemClick: (Movie) -> Unit) {
        binding.apply {
            tvTitle.text = movie.title
            tvDuration.text = movie.duration
            tvRating.text = movie.rating

            // Menggunakan Glide untuk load gambar
            Glide.with(itemView.context)
                .load(movie.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.movie_placeholder)
                .into(ivPoster)

            // Set onClick listener
            root.setOnClickListener {
                onItemClick(movie)
            }
        }
    }
}