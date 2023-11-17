package com.angelika.jetpackcomposelesson4.di

import com.angelika.jetpackcomposelesson4.data.remote.RetrofitClient
import com.angelika.jetpackcomposelesson4.data.remote.apiservice.AnimeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService(): AnimeApiService = retrofitClient.animeApi
}