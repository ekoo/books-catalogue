package com.ekoo.bookapps.model


import com.google.gson.annotations.SerializedName

data class BookDetailResponseModel(
    @SerializedName("result")
    val result: Result,
    @SerializedName("success")
    val success: Boolean
) {
    data class Result(
        @SerializedName("auto_buy_chapter")
        val autoBuyChapter: Boolean,
        @SerializedName("average_rate")
        val averageRate: Int,
        @SerializedName("BookChapter_by_book_id")
        val bookChapterByBookId: List<BookChapterByBookId>,
        @SerializedName("book_url")
        val bookUrl: String,
        @SerializedName("category")
        val category: Any?,
        @SerializedName("challenge_id")
        val challengeId: Any?,
        @SerializedName("chapter_count")
        val chapterCount: Int,
        @SerializedName("chapter_paid_count")
        val chapterPaidCount: Int,
        @SerializedName("cover_url")
        val coverUrl: String,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("daily")
        val daily: String,
        @SerializedName("decimal_rate")
        val decimalRate: Double,
        @SerializedName("desc")
        val desc: String,
        @SerializedName("download")
        val download: Int,
        @SerializedName("full_price")
        val fullPrice: Int,
        @SerializedName("full_purchase")
        val fullPurchase: Boolean,
        @SerializedName("full_purchased")
        val fullPurchased: Boolean,
        @SerializedName("genres")
        val genres: List<Genre>,
        @SerializedName("happyhour")
        val happyhour: Boolean,
        @SerializedName("hashtags")
        val hashtags: List<Any>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_contract_actived")
        val isContractActived: Boolean,
        @SerializedName("is_free")
        val isFree: Boolean,
        @SerializedName("isNew")
        val isNew: Boolean,
        @SerializedName("is_update")
        val isUpdate: Boolean,
        @SerializedName("nominasi")
        val nominasi: Any?,
        @SerializedName("Related_by_book")
        val relatedByBook: List<RelatedByBook>,
        @SerializedName("reviews")
        val reviews: List<Review>,
        @SerializedName("schedule_daily")
        val scheduleDaily: Any?,
        @SerializedName("schedule_task")
        val scheduleTask: String,
        @SerializedName("status")
        val status: String,
        @SerializedName("synopsis")
        val synopsis: String,
        @SerializedName("time_to_vote")
        val timeToVote: Boolean,
        @SerializedName("title")
        val title: String,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("url_landing")
        val urlLanding: String,
        @SerializedName("User_review")
        val userReview: String,
        @SerializedName("view_count")
        val viewCount: Int,
        @SerializedName("vote_count")
        val voteCount: String,
        @SerializedName("voted")
        val voted: Boolean,
        @SerializedName("Writer_by_writer_id")
        val writerByWriterId: WriterByWriterId,
        @SerializedName("writer_id")
        val writerId: Int
    ) {
        data class BookChapterByBookId(
            @SerializedName("book_id")
            val bookId: Int,
            @SerializedName("chapter_sequence")
            val chapterSequence: Int,
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("is_purchased")
            val isPurchased: Boolean,
            @SerializedName("is_readed")
            val isReaded: Boolean,
            @SerializedName("is_warning")
            val isWarning: Any?,
            @SerializedName("like_count")
            val likeCount: Int,
            @SerializedName("new")
            val new: Boolean,
            @SerializedName("price")
            val price: Int,
            @SerializedName("schedule_task")
            val scheduleTask: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("view_by_user")
            val viewByUser: Int,
            @SerializedName("view_count")
            val viewCount: Int
        )

        data class Genre(
            @SerializedName("count")
            val count: Int,
            @SerializedName("icon_url")
            val iconUrl: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("is_primary")
            val isPrimary: Int?,
            @SerializedName("title")
            val title: String
        )

        data class RelatedByBook(
            @SerializedName("cover_url")
            val coverUrl: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("title")
            val title: String
        )

        data class Review(
            @SerializedName("id")
            val id: Int,
            @SerializedName("rating")
            val rating: Int,
            @SerializedName("review")
            val review: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("User_by_reviewer_id")
            val userByReviewerId: UserByReviewerId,
            @SerializedName("user_id")
            val userId: Int
        ) {
            data class UserByReviewerId(
                @SerializedName("email")
                val email: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("photo_url")
                val photoUrl: String,
                @SerializedName("username")
                val username: String
            )
        }

        data class WriterByWriterId(
            @SerializedName("id")
            val id: Int,
            @SerializedName("status")
            val status: Any?,
            @SerializedName("User_by_user_id")
            val userByUserId: UserByUserId,
            @SerializedName("user_id")
            val userId: Int
        ) {
            data class UserByUserId(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("photo_url")
                val photoUrl: String,
                @SerializedName("username")
                val username: String
            )
        }
    }
}