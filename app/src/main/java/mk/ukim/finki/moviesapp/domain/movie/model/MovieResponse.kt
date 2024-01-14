package mk.ukim.finki.moviesapp.domain.movie.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(val page: Int, val results: List<Movie>)