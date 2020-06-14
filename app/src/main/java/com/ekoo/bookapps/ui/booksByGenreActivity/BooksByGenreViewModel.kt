package com.ekoo.bookapps.ui.booksByGenreActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekoo.bookapps.repository.BooksByGenreRepository
import com.ekoo.bookapps.utils.FetchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BooksByGenreViewModel(private val repository: BooksByGenreRepository = BooksByGenreRepository()): ViewModel() {

    val fetchState: LiveData<FetchState> get() = _fetchState
    private val _fetchState = MutableLiveData<FetchState>()
    private var fetchStateJob: Job? = null

    fun getBooksByGenre(genreId: String){
        fetchStateJob?.cancel()
        fetchStateJob = viewModelScope.launch(Dispatchers.IO){
            repository.getBooksByGenre(genreId).collect {
                _fetchState.postValue(it)
            }
        }
    }

}