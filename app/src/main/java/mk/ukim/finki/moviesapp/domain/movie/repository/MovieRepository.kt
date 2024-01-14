package mk.ukim.finki.moviesapp.domain.movie.repository

import mk.ukim.finki.moviesapp.domain.movie.LocalMovieDataSource
import mk.ukim.finki.moviesapp.domain.movie.RemoteMovieDataSource
import mk.ukim.finki.moviesapp.domain.movie.model.Movie
import mk.ukim.finki.moviesapp.utils.NetworkConnectivity

class MovieRepository(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource,
    private val networkConnectivity: NetworkConnectivity
) {
    suspend fun queryMovies(query: String): List<Movie> {
        if (networkConnectivity.isNetworkAvailable) {
            return remoteMovieDataSource.search(query).apply { localMovieDataSource.saveAll(this) }
        }
        return localMovieDataSource.searchMovies(query)
    }

    suspend fun listMovies(): List<Movie> {
        return localMovieDataSource.getAll()
    }
}