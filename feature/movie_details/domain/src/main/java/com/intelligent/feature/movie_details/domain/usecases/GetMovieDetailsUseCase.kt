package com.intelligent.feature.movie_details.domain.usecases

import com.intelligent.core.common.UiEvent
import com.intelligent.core.common.errorCatch
import com.intelligent.feature.movie_details.domain.repository.MovieDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository
) {

    operator fun invoke(
        id: String,
        apiKey: String
    ) = flow {
        emit(UiEvent.Loading)
        emit(
            UiEvent.Success(
                data = movieDetailsRepository.getMovieDetails(
                    id = id, apiKey = apiKey
                )
            )
        )
    }.errorCatch().flowOn(Dispatchers.IO)
}