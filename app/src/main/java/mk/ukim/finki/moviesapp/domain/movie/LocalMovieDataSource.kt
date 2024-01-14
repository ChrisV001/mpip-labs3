package mk.ukim.finki.moviesapp.domain.movie

import mk.ukim.finki.moviesapp.domain.movie.model.Movie

interface LocalMovieDataSource {
    suspend fun insert(movie: Movie)

    suspend fun saveAll(movies: List<Movie>)

    suspend fun delete(id: Int)

    suspend fun getAll(): List<Movie>

    suspend fun searchMovies(query: String): List<Movie>
}