package com.ekoo.bookapps.ui.genreListFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekoo.bookapps.repository.GenreListRepository
import com.ekoo.bookapps.utils.FetchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GenreListViewModel(private val repository: GenreListRepository = GenreListRepository()) : ViewModel() {

    val allGenre: LiveData<FetchState> get() = _allGenre
    private val _allGenre = MutableLiveData<FetchState>()
    private var getAllGenreJob: Job? = null

    fun getAllGenre(){
        getAllGenreJob?.cancel()
        getAllGenreJob = viewModelScope.launch(Dispatchers.IO){
            repository.getAllGenres().collect {
                _allGenre.postValue(it)
            }
        }
    }

    init {
        getAllGenre()
    }
}