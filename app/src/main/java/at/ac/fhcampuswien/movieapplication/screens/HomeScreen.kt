package at.ac.fhcampuswien.movieapplication.screens

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import at.ac.fhcampuswien.movieapplication.models.Movie
import at.ac.fhcampuswien.movieapplication.models.getMovies
import at.ac.fhcampuswien.movieapplication.widgets.MovieRow

@Composable
fun HomeScreen(){
    Scaffold {
        MainContent()
    }
}

@Composable
fun MainContent(movies: List<Movie> = getMovies()){
    LazyColumn {
        items(movies){ movie ->
            MovieRow(movie) { movieId ->
                Log.d("MainContent", "My callback value: $movieId")
            }
        }

        /*
        item(){
            Text(text = "Header")
        }
        items(5){
            Text(text = "mytext")
        }
         */
    }
}