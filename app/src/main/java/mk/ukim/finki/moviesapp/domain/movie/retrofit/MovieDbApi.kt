package mk.ukim.finki.moviesapp.domain.movie.retrofit

import mk.ukim.finki.moviesapp.domain.movie.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbApi {

    @GET("search/movie")
    suspend fun search(@Query("query") query:String): Response<MovieResponse>
}