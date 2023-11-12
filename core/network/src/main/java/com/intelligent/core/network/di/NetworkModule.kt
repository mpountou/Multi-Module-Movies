package com.intelligent.core.network.di

import com.intelligent.core.network.ApiService
import com.intelligent.core.network.data_providers.MovieDataProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun provideApiService(factory: MoshiConverterFactory): ApiService = Retrofit
        .Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(factory)
        .build()
        .create(ApiService::class.java)

    @Provides
    fun provideMovieDataProvider(apiService: ApiService) = MovieDataProviders(apiService)
}