package mk.ukim.finki.moviesapp.ui.movies

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.moviesapp.domain.movie.repository.MovieRepository
import mk.ukim.finki.moviesapp.domain.movie.retrofit.MovieDbApiProvider
import mk.ukim.finki.moviesapp.domain.movie.retrofit.RetrofitMovieDataSource
import mk.ukim.finki.moviesapp.domain.movie.room.AppDatabase
import mk.ukim.finki.moviesapp.domain.movie.room.RoomMovieDataSource
import mk.ukim.finki.moviesapp.utils.NetworkConnectivity

class MoviesViewModelFactory(private val context: Context):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(MovieRepository(RetrofitMovieDataSource(MovieDbApiProvider.getMovieDbApi()),
                RoomMovieDataSource(AppDatabase.getDatabase(context).movieDao()),
                    NetworkConnectivity(context)
            ))
    }
}