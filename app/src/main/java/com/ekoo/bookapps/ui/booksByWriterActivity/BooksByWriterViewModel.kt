package com.ekoo.bookapps.ui.booksByWriterActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekoo.bookapps.repository.BooksByWriterRepository
import com.ekoo.bookapps.utils.FetchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BooksByWriterViewModel(private val repository: BooksByWriterRepository = BooksByWriterRepository()): ViewModel() {

    val fetchState: LiveData<FetchState> get() = _fetchState
    private val _fetchState = MutableLiveData<FetchState>()
    private var fetchStateJob: Job? = null

    fun getBooksByWriter(writerId: Int){
        fetchStateJob?.cancel()
        fetchStateJob = viewModelScope.launch(Dispatchers.IO){
            repository.getBooksByWriter(writerId).collect {
                _fetchState.postValue(it)
            }
        }
    }
}