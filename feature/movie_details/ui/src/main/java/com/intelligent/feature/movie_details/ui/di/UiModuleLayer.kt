package com.intelligent.feature.movie_details.ui.di

import com.intelligent.feature.movie_details.ui.navigation.MovieDetailsApi
import com.intelligent.feature.movie_details.ui.navigation.MovieDetailsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModuleLayer {

    @Provides
    fun providesMovieDetailsApi(): MovieDetailsApi = MovieDetailsApiImpl()

}