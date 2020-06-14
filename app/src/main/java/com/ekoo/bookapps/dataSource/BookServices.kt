package com.ekoo.bookapps.dataSource

import com.ekoo.bookapps.model.*
import com.ekoo.bookapps.utils.HEADER
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface BookServices {

    @Headers(HEADER)
    @GET("api/v2/cabaca/_table/genre")
    suspend fun getAllGenre(): GenreResponseModel

    @Headers(HEADER)
    @GET("api/v2/book/category?")
    suspend fun getBooksByGenre(@Query("id") genreId: String): BookListByGenreResponseModel

    @Headers(HEADER)
    @GET("api/v2/writer/detail/{user_id}")
    suspend fun getBooksByWriter(@Path("user_id") writerId: Int): WriterDetailResponseModel

    @Headers(HEADER)
    @GET("api/v2/book/uptodate?limit=7")
    suspend fun getLatestBooks(): LatestBookResponseModel

    @Headers(HEADER)
    @GET("api/v2/book/detail/{book_id}")
    suspend fun getBookById(@Path("book_id") bookId: String): BookDetailResponseModel

}