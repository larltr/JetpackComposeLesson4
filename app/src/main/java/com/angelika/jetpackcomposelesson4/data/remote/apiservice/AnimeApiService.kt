package com.angelika.jetpackcomposelesson4.data.remote.apiservice

import com.angelika.jetpackcomposelesson4.models.KitsuModel
import com.angelika.kitsu.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("filter[season]") season: String = "winter"
    ): KitsuResponse<KitsuModel>
}