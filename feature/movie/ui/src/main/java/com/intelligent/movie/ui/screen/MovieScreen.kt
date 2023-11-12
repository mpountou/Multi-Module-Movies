package com.intelligent.movie.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.intelligent.core.common.api_constants.ApiConstants
import com.intelligent.feature.movie.domain.model.Movie
import com.intelligent.ui.components.ErrorScreen
import com.intelligent.ui.components.LoadingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(
    viewModel: MovieSearchViewModel,
    navController: NavController
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getMovieList(apiKey = ApiConstants.key)
    }

    val uiState by viewModel.movieListUiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        when {

            !uiState.error.isNullOrEmpty() -> {
                ErrorScreen(errorMessage = uiState.error!!)
            }

            uiState.isLoading -> {
                LoadingScreen()
            }

            uiState.data != null -> {

                MovieScreenContent(
                    movieList = uiState.data!!,
                    navController = navController
                )

            }
        }
    }
}

@Composable
fun MovieScreenContent(
    movieList: List<Movie>,
    navController: NavController
) {
    if (movieList.isNotEmpty()) {
        LazyVerticalGrid(GridCells.Adaptive(minSize = 100.dp)) {
            items(movieList) {
                Box(
                    modifier = Modifier
                        .heightIn()
                        .clickable {
                            navController.navigate("movie_details/${it.movieId}")
                        }
                ) {
                    AsyncImage(
                        model = it.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}