package mk.ukim.finki.moviesapp.domain.movie.retrofit

import mk.ukim.finki.moviesapp.domain.movie.RemoteMovieDataSource
import mk.ukim.finki.moviesapp.domain.movie.model.Movie
import java.lang.Exception

class RetrofitMovieDataSource(private val movieDbApi: MovieDbApi):RemoteMovieDataSource {


    override suspend fun search(query: String): List<Movie> {
        val movieResponse = movieDbApi.search(query)
        val responseBody = movieResponse.body()
        if (movieResponse.isSuccessful && responseBody!=null) {
            return responseBody.results
        }
        throw Exception(movieResponse.message())
    }
}