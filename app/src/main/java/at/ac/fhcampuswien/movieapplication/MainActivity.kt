package at.ac.fhcampuswien.movieapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.ac.fhcampuswien.movieapplication.ui.theme.MovieApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent(movies: List<String> = listOf("Harry Potter", "Marry Poppins", "Terminator", "LotR", "In Bruges")){
    LazyColumn {
        // item { Text(text = "Header") }   // add a single composable to LazyColumn

        items(items = movies) { movie ->    // add a list of composables to LazyColumn
            MovieRow(movie = movie)         // render MovieRow composable for each item
        }
        /*
        itemsIndexed(movies){ index, movie ->   // add a list of composables with index
            MovieRow(movie)
        }
         */

    }
}

@Composable
fun MovieRow(movie: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .size(100.dp)
                .padding(12.dp),
                elevation = 6.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie pic")
            }

            Text(text = movie, style = MaterialTheme.typography.h6)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieApplicationTheme {
        MainContent()
    }
}