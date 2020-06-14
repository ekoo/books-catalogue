package com.ekoo.bookapps.model


import com.google.gson.annotations.SerializedName

data class BookListByGenreResponseModel(
    @SerializedName("result")
    val bookList: List<BookModel>,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("test")
    val test: Test
) {
    data class BookModel(
        @SerializedName("book_url")
        val bookUrl: String,
        @SerializedName("chapter_count")
        val chapterCount: Int,
        @SerializedName("cover_url")
        val coverUrl: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("Genre_by_genre_id")
        val genreByGenreId: GenreByGenreId,
        @SerializedName("genre_id")
        val genreId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("isNew")
        val isNew: Boolean,
        @SerializedName("is_update")
        val isUpdate: Boolean,
        @SerializedName("rate_sum")
        val rateSum: Double,
        @SerializedName("schedule_task")
        val scheduleTask: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("view_count")
        val viewCount: Int,
        @SerializedName("Writer_by_writer_id")
        val writerByWriterId: WriterByWriterId,
        @SerializedName("writer_id")
        val writerId: Int
    ) {
        data class GenreByGenreId(
            @SerializedName("count")
            val count: Int,
            @SerializedName("icon_url")
            val iconUrl: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("title")
            val title: String
        )

        data class WriterByWriterId(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("kelas")
            val kelas: Any?,
            @SerializedName("royalty_id")
            val royaltyId: Int?,
            @SerializedName("schedule_task")
            val scheduleTask: String,
            @SerializedName("status")
            val status: Any?,
            @SerializedName("type")
            val type: String,
            @SerializedName("User_by_user_id")
            val userByUserId: UserByUserId,
            @SerializedName("user_id")
            val userId: Int
        ) {
            data class UserByUserId(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String
            )
        }
    }

    data class Test(
        @SerializedName("id")
        val id: Int
    )
}