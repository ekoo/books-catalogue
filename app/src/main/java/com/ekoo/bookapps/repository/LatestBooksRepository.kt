package com.ekoo.bookapps.repository

import com.ekoo.bookapps.dataSource.BookServices
import com.ekoo.bookapps.dataSource.BookServicesBuilder
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import kotlinx.coroutines.flow.flow

class LatestBooksRepository(private val bookServices: BookServices = BookServicesBuilder.build()) {

    fun getLatestBooks() = flow {
        emit(Loading)
        try {
            val result = bookServices.getLatestBooks()
            emit(Success(result))
        }catch (e: Exception){
            emit(Error(e))
        }
    }

}