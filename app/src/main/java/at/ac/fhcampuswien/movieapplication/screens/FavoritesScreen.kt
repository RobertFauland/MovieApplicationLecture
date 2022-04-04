package at.ac.fhcampuswien.movieapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import at.ac.fhcampuswien.movieapplication.models.Movie
import at.ac.fhcampuswien.movieapplication.navigation.MovieScreens
import at.ac.fhcampuswien.movieapplication.viewmodels.FavoritesViewModel
import at.ac.fhcampuswien.movieapplication.widgets.MovieRow
import at.ac.fhcampuswien.movieapplication.widgets.SimpleTopAppBar

@Composable
fun FavoritesScreen(navController: NavController, viewModel: FavoritesViewModel){
    //
    Scaffold(topBar = {
        SimpleTopAppBar(arrowBackClicked = { navController.popBackStack() }) {
            Text(text = "My Favorite Movies")
        }
    }){
        MainContent(movieList = viewModel.favoriteMovies, navController = navController)
    }
}

@Composable
fun MainContent(movieList: List<Movie>, navController: NavController){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList){ movie ->
                MovieRow(
                    movie = movie,
                    onItemClick = {
                            item ->
                        navController.navigate(route = MovieScreens.DetailScreen.name+"/$item")
                    }
                )
            }
        }
    }
}