package com.intelligent.multi_module_movies.di

import com.intelligent.feature.movie_details.ui.navigation.MovieDetailsApi
import com.intelligent.movie.ui.navigation.MovieApi
import com.intelligent.multi_module_movies.navigation.NavigationProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(
        movieApi: MovieApi,
        movieDetailsApi: MovieDetailsApi
    ) = NavigationProvider(
        movieApi = movieApi,
        movieDetailsApi = movieDetailsApi
    )

}