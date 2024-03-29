package at.ac.fhcampuswien.movieapplication.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import at.ac.fhcampuswien.movieapplication.models.Movie

    class FavoritesViewModel : ViewModel() {

        private val _favoriteMovies = mutableStateListOf<Movie>() // mutableListOf<Movie>()
        val favoriteMovies: List<Movie>
            get() = _favoriteMovies


        fun addToFavorites(movie: Movie) {
            if(!exists(movie = movie)){
                _favoriteMovies.add(movie)
            }
        }

        fun removeFromFavorites(movie: Movie){
            _favoriteMovies.remove(movie)
        }

        private fun exists(movie: Movie) : Boolean {
            return _favoriteMovies.any {m -> m.id == movie.id }
        }

        fun isFavorite(movie: Movie) : Boolean {
            return exists(movie)
        }
    }



