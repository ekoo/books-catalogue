package com.ekoo.bookapps.utils


sealed class FetchState
object Loading : FetchState()
data class Success(val response: Any) : FetchState()
data class Error(val exception: Exception) : FetchState()