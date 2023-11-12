package com.intelligent.feature.movie_details.data.di

import com.intelligent.core.network.data_providers.MovieDataProviders
import com.intelligent.feature.movie_details.data.repository.MovieDetailsRepositoryImpl
import com.intelligent.feature.movie_details.domain.repository.MovieDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieDetailsRepository(movieDataProviders: MovieDataProviders): MovieDetailsRepository =
        MovieDetailsRepositoryImpl(
            movieDataProviders = movieDataProviders
        )

}