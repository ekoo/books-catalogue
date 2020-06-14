package com.ekoo.bookapps.repository

import com.ekoo.bookapps.dataSource.BookServices
import com.ekoo.bookapps.dataSource.BookServicesBuilder
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import kotlinx.coroutines.flow.flow

class BooksByGenreRepository(private val bookServices: BookServices = BookServicesBuilder.build()) {

    fun getBooksByGenre(genreId: String) = flow {
        emit(Loading)
        try {
            val result = bookServices.getBooksByGenre(genreId)
            emit(Success(result))
        }catch (e: Exception){
            emit(Error(e))
        }
    }

}