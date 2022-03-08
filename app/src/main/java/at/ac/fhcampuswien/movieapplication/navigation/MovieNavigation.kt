package at.ac.fhcampuswien.movieapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.ac.fhcampuswien.movieapplication.screens.DetailScreen
import at.ac.fhcampuswien.movieapplication.screens.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController() // create NavController instance

    NavHost(navController = navController, startDestination = "homescreen"){
        composable("homescreen") { HomeScreen() }
        composable("detailscreen") { DetailScreen() }
    }
}