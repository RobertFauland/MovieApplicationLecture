package at.ac.fhcampuswien.movieapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.ac.fhcampuswien.movieapplication.models.Movie
import at.ac.fhcampuswien.movieapplication.models.getMovies
import at.ac.fhcampuswien.movieapplication.widgets.HorizontalScrollableImageView
import at.ac.fhcampuswien.movieapplication.widgets.MovieRow
import at.ac.fhcampuswien.movieapplication.widgets.SimpleTopAppBar

fun filterMovie(movieId: String?): Movie {
    return getMovies().filter { it.id == movieId}[0]
}

@Composable
fun DetailScreen(navController: NavController, movieId: String?){
    val movie = filterMovie(movieId = movieId)

    Scaffold(
        topBar = {
            SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
                Text(text = movie.title)
            }
        }
    ) {
        MainContent(movie = movie)
    }
}

@Composable
fun MainContent(movie: Movie){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            MovieRow(movie = movie)

            Spacer(modifier = Modifier.height(8.dp))

            Divider()

            Text(text = "Movie Images", style = MaterialTheme.typography.h5)

            HorizontalScrollableImageView(movie = movie)
        }
    }
}