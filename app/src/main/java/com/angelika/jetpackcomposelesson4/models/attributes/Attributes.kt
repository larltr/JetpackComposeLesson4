package com.angelika.jetpackcomposelesson4.models.attributes

import com.google.gson.annotations.SerializedName

data class Attributes(

    @SerializedName("synopsis")
    val detail: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("titles")
    val title: Titles,

    @SerializedName("posterImage")
    val posterImage: PosterImage,

    @SerializedName("averageRating")
    val averageRating: Double,

    @SerializedName("status")
    val status: String
)