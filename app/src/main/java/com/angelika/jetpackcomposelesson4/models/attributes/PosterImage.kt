package com.angelika.jetpackcomposelesson4.models.attributes

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("small")
    val small: String,
    @SerializedName("tiny")
    val tiny: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("large")
    val large: String,
    @SerializedName("original")
    val original: String
)