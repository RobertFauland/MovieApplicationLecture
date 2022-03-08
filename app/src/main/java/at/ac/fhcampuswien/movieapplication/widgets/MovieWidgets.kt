package at.ac.fhcampuswien.movieapplication.widgets

import androidx.compose.foundation.layout.*
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
import at.ac.fhcampuswien.movieapplication.models.Movie
import at.ac.fhcampuswien.movieapplication.models.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0]) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier
                    .size(130.dp)
                    .padding(12.dp),
                elevation = 6.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie pic")
            }

            Column() {
                Text(text = movie.title, style = MaterialTheme.typography.h5)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)
            }

        }
    }

}