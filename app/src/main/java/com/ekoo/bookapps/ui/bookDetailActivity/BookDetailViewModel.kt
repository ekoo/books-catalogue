package com.ekoo.bookapps.ui.bookDetailActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekoo.bookapps.repository.BookDetailRepository
import com.ekoo.bookapps.utils.FetchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookDetailViewModel(private val repository: BookDetailRepository = BookDetailRepository()): ViewModel() {

    val bookDetail: LiveData<FetchState> get() = _bookDetail
    private val _bookDetail = MutableLiveData<FetchState>()
    private var getBookByIdJob: Job? = null

    fun getBookById(bookId: String){
        getBookByIdJob?.cancel()
        getBookByIdJob = viewModelScope.launch(Dispatchers.IO){
            repository.getBookById(bookId).collect {
                _bookDetail.postValue(it)
            }
        }
    }

}