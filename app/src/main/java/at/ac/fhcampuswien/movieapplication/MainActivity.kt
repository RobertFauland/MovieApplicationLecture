package at.ac.fhcampuswien.movieapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import at.ac.fhcampuswien.movieapplication.navigation.MovieNavigation
import at.ac.fhcampuswien.movieapplication.ui.theme.MovieApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate")


        setContent {
           // val vm2: FavoritesViewModel = viewModel()
            MovieApplicationTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MovieNavigation()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieApplicationTheme {
        MovieNavigation()
    }
}