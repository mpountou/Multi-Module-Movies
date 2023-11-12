package com.intelligent.movie.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intelligent.core.common.UiEvent
import com.intelligent.feature.movie.domain.use_case.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieListUiState = MutableStateFlow(MovieSearchUiState())
    val movieListUiState = _movieListUiState.asStateFlow()

    fun getMovieList(apiKey: String) = viewModelScope.launch {
        getMovieListUseCase(
            apiKey = apiKey
        ).collect { result ->
            when (result) {
                is UiEvent.Error -> _movieListUiState.update {
                    it.copy(
                        isLoading = true,
                        error = result.message
                    )
                }

                UiEvent.Loading -> _movieListUiState.update { it.copy(isLoading = true) }
                is UiEvent.Success -> {
                    _movieListUiState.update {
                        it.copy(
                            isLoading = false,
                            data = result.data
                        )
                    }
                }
            }
        }
    }

}