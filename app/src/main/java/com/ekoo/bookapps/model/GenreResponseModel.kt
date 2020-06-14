package com.ekoo.bookapps.model


import com.google.gson.annotations.SerializedName

data class GenreResponseModel(
    @SerializedName("resource")
    val genreList: List<GenreModel>
) {
    data class GenreModel(
        @SerializedName("count")
        val count: Int,
        @SerializedName("icon_url")
        val iconUrl: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String
    )
}