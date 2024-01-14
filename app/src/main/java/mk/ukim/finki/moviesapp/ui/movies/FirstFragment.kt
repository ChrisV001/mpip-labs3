package mk.ukim.finki.moviesapp.ui.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import mk.ukim.finki.moviesapp.R
import mk.ukim.finki.moviesapp.adapters.MovieAdapter
import mk.ukim.finki.moviesapp.databinding.FragmentMoviesBinding

class FirstFragment : Fragment(R.layout.fragment_movies) {

    private var _binding: FragmentMoviesBinding? = null

    private val binding get() = _binding!!

    private lateinit var moviesViewModel: MoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMoviesBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

        var adapter: MovieAdapter = MovieAdapter()
        binding.list.adapter = adapter

        moviesViewModel.getMovieLiveData().observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }

        binding.button.setOnClickListener {
            val query = binding.editQuery.text.toString()
            if (query.isEmpty()) {
                Snackbar.make(view, R.string.please_enter_query, Snackbar.LENGTH_LONG).show()
            } else {
                moviesViewModel.search(query)
            }

        }

        moviesViewModel.listAll()
    }


}