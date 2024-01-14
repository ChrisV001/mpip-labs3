package mk.ukim.finki.moviesapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mk.ukim.finki.moviesapp.domain.movie.model.Movie
import mk.ukim.finki.moviesapp.domain.movie.repository.MovieRepository

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovieLiveData(): LiveData<List<Movie>> = moviesLiveData

    fun search(query:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.queryMovies(query)
            moviesLiveData.postValue(movies)
        }
    }

    fun listAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.listMovies()
            moviesLiveData.postValue(movies)
        }
    }
}