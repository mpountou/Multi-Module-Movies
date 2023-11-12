package com.intelligent.feature.movie.data.di

import com.intelligent.core.network.data_providers.MovieDataProviders
import com.intelligent.feature.movie.data.repository.MovieRepositoryImpl
import com.intelligent.feature.movie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepository(
        movieDataProviders: MovieDataProviders
    ): MovieRepository =
        MovieRepositoryImpl(
            movieDataProviders = movieDataProviders
        )

}