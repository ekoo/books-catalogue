package com.ekoo.bookapps.repository

import com.ekoo.bookapps.dataSource.BookServices
import com.ekoo.bookapps.dataSource.BookServicesBuilder
import com.ekoo.bookapps.utils.Error
import com.ekoo.bookapps.utils.Loading
import com.ekoo.bookapps.utils.Success
import kotlinx.coroutines.flow.flow

class BooksByWriterRepository(private val bookServices: BookServices = BookServicesBuilder.build()) {

    fun getBooksByWriter(writerId: Int) = flow {
        emit(Loading)
        try {
            val result = bookServices.getBooksByWriter(writerId)
            emit(Success(result))
        }catch (e: Exception){
            emit(Error(e))
        }
    }
}