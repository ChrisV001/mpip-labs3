package mk.ukim.finki.moviesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.ukim.finki.moviesapp.R
import mk.ukim.finki.moviesapp.domain.movie.model.Movie

class MovieAdapter(private val movies: ArrayList<Movie> = ArrayList<Movie>()):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    class MovieViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private var imageView: ImageView = view.findViewById(R.id.movie_image)
        private var titleText:TextView = view.findViewById(R.id.movie_title)

        fun bind(movie:Movie) {
            Glide.with(imageView)
                .load(movie.posterPath)
                .centerCrop().placeholder(R.drawable.ic_movie).into(imageView)
            titleText.text = movie.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_movie,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies.clear()
        if (movies!=null) {
            this.movies.addAll(movies)
        }
        notifyDataSetChanged()
    }
}