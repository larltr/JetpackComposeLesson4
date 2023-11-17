package com.angelika.jetpackcomposelesson4.data.repositories

import android.util.Log
import com.angelika.jetpackcomposelesson4.data.remote.apiservice.AnimeApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) {

    fun fetchAnime() = flow {
        try {
            emit(animeApiService.fetchAnime())
        } catch (exception: Exception) {
            Log.e("exception", "you have a big problem bro")
        }
    }
}