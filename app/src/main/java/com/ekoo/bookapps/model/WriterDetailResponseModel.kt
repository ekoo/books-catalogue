package com.ekoo.bookapps.model


import com.google.gson.annotations.SerializedName

data class WriterDetailResponseModel(
    @SerializedName("result")
    val result: Result,
    @SerializedName("success")
    val success: Boolean
) {
    data class Result(
        @SerializedName("birthday")
        val birthday: String,
        @SerializedName("coin")
        val coin: Int,
        @SerializedName("count_follower")
        val countFollower: Int,
        @SerializedName("count_following")
        val countFollowing: Int,
        @SerializedName("current_level")
        val currentLevel: Int,
        @SerializedName("deskripsi")
        val deskripsi: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("following_user")
        val followingUser: List<Any>,
        @SerializedName("gender")
        val gender: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_following")
        val isFollowing: Boolean,
        @SerializedName("karya")
        val karya: List<Any>,
        @SerializedName("link_user")
        val linkUser: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("photo_url")
        val photoUrl: String,
        @SerializedName("reading_list")
        val readingList: List<Any>,
        @SerializedName("username")
        val username: String
    )
}