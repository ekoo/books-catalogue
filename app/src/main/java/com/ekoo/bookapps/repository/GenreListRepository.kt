package com.ekoo.bookapps.repository

import com.ekoo.bookapps.dataSource.BookServices
import com.ekoo.bookapps.dataSource.BookServicesBuilder
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import kotlinx.coroutines.flow.flow

class GenreListRepository(private val bookServices: BookServices = BookServicesBuilder.build()) {

    fun getAllGenres() = flow {
        emit(Loading)
        try {
            val result = bookServices.getAllGenre()
            emit(Success(result))
        }catch (e: Exception){
            emit(Error(e))
        }
    }
}