package com.intelligent.feature.movie_details.domain.di

import com.intelligent.feature.movie_details.domain.repository.MovieDetailsRepository
import com.intelligent.feature.movie_details.domain.usecases.GetMovieDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun providesMovieDetailsUseCase(movieDetailsRepository: MovieDetailsRepository) =
        GetMovieDetailsUseCase(
            movieDetailsRepository = movieDetailsRepository
        )

}