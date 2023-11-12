package com.intelligent.feature.movie.domain.di

import com.intelligent.feature.movie.domain.repository.MovieRepository
import com.intelligent.feature.movie.domain.use_case.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetMovieListUseCase(movieRepository: MovieRepository) =
        GetMovieListUseCase(movieRepository)
}