package com.intelligent.feature.movie_details.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intelligent.core.common.UiEvent
import com.intelligent.feature.movie_details.domain.usecases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _movieDetails = MutableStateFlow(MovieDetailsUiState())
    val movieDetails = _movieDetails.asStateFlow()

    fun getMovieDetails(id: String, apiKey: String) = viewModelScope.launch {
        getMovieDetailsUseCase(
            id = id,
            apiKey = apiKey
        ).collect {
            when (it) {
                UiEvent.Loading -> _movieDetails.update { movieDetails ->
                    movieDetails.copy(
                        isLoading = true
                    )
                }

                is UiEvent.Error -> _movieDetails.update { movieDetails ->
                    movieDetails.copy(
                        isLoading = false,
                        error = movieDetails.error
                    )
                }

                is UiEvent.Success -> _movieDetails.update { movieDetails ->
                    movieDetails.copy(
                        isLoading = false,
                        data = it.data
                    )
                }
            }
        }
    }


}