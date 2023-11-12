package com.intelligent.feature.movie_details.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.intelligent.core.common.api_constants.ApiConstants
import com.intelligent.ui.components.ErrorScreen
import com.intelligent.ui.components.LoadingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    id: String,
    viewModel: MovieDetailsViewModel
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getMovieDetails(
            id = id,
            apiKey = ApiConstants.key
        )
    }

    val movieDetails = viewModel.movieDetails.collectAsState()

    Scaffold(
        content = {

            when {
                movieDetails.value.isLoading -> {
                    LoadingScreen()
                }

                movieDetails.value.error.isNotBlank() -> {
                    ErrorScreen(
                        errorMessage = movieDetails.value.error
                    )
                }

                movieDetails.value.data != null -> {
                    MovieDetailsContent(
                        imageUrl = movieDetails.value.data!!.imageUrl,
                        title = movieDetails.value.data!!.title,
                        description = movieDetails.value.data!!.description
                    )
                }
            }

        }
    )
}


@Composable
fun MovieDetailsContent(
    imageUrl: String,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillHeight
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}