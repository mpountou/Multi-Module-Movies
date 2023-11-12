package com.intelligent.feature.movie.domain.use_case

import com.intelligent.core.common.UiEvent
import com.intelligent.core.common.errorCatch
import com.intelligent.feature.movie.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GetMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    operator fun invoke(apiKey: String) = flow {
        emit(UiEvent.Loading)
        emit(
            UiEvent.Success(
                movieRepository.getMovieList(
                    apiKey = apiKey
                )
            )
        )
    }.errorCatch().flowOn(Dispatchers.IO)

}