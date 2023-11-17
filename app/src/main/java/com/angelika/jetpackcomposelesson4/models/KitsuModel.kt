package com.angelika.jetpackcomposelesson4.models

import com.angelika.jetpackcomposelesson4.models.attributes.Attributes
import com.google.gson.annotations.SerializedName

data class KitsuModel(

    @SerializedName("id")
    val id: String,

    @SerializedName("attributes")
    val attributes: Attributes
)