package com.ekoo.bookapps.ui.latestBooksFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekoo.bookapps.repository.LatestBooksRepository
import com.ekoo.bookapps.utils.FetchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LatestBooksViewModel(private val repository: LatestBooksRepository = LatestBooksRepository()): ViewModel() {

    val latestBook: LiveData<FetchState> get() = _latestBooks
    private val _latestBooks = MutableLiveData<FetchState>()
    private var getLatestBookJob: Job? = null
    
    fun getLatestBooks(){
        getLatestBookJob?.cancel()
        getLatestBookJob = viewModelScope.launch(Dispatchers.IO){
            repository.getLatestBooks().collect {
                _latestBooks.postValue(it)
            }
        }
    }

    init {
        getLatestBooks()
    }
}