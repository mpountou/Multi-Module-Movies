package com.intelligent.movie.ui.di

import com.intelligent.movie.ui.navigation.MovieApi
import com.intelligent.movie.ui.navigation.MovieApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModuleLayer {

    @Provides
    fun provideMovieApi(): MovieApi = MovieApiImpl()

}