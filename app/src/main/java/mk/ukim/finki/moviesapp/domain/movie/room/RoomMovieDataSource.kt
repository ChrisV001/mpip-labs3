package mk.ukim.finki.moviesapp.domain.movie.room

import mk.ukim.finki.moviesapp.domain.movie.LocalMovieDataSource
import mk.ukim.finki.moviesapp.domain.movie.model.Movie

class RoomMovieDataSource(private val movieDao: MovieDao): LocalMovieDataSource {
    override suspend fun insert(movie: Movie) {
        movieDao.insert(movie);
    }

    override suspend fun saveAll(movies: List<Movie>) {
        for (movie in movies) {
            movieDao.insert(movie)
        }
    }

    override suspend fun delete(id: Int) {
        movieDao.delete(id)
    }

    override suspend fun getAll(): List<Movie> {
        return movieDao.getAll()
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return movieDao.searchMovies(query)
    }

}