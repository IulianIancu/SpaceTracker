package com.iulian.iancu.spacetracker.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.iulian.iancu.spacetracker.data.Result
import com.iulian.iancu.spacetracker.data.SpaceRepository
import kotlinx.coroutines.*

class MainViewModel constructor(
    private val repository: SpaceRepository,
) : ViewModel() {

    private var job: Job? = null
    private val _state = MutableLiveData(State(null, null))
    val state: LiveData<State> get() = _state
    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.postValue(_state.value?.copy(error = Error.Unknown))
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun getLatestLaunches(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getUpdates()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    _state.postValue(
                        _state.value?.copy(
                            error = null,
                            result = response.body()
                        )
                    )
                } else {
                    _state.postValue(_state.value?.copy(error = Error.Network))
                }
            }
        }
    }
}

data class State(
    val error: Error?,
    val result: Result?
)

sealed class Error() {
    object Network : Error()
    object Unknown : Error()
}