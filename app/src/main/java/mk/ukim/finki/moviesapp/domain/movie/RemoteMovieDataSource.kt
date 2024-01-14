package mk.ukim.finki.moviesapp.domain.movie

import mk.ukim.finki.moviesapp.domain.movie.model.Movie

interface RemoteMovieDataSource {
    suspend fun search(query:String): List<Movie>
}