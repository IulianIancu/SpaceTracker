package com.iulian.iancu.spacetracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iulian.iancu.spacetracker.data.SpaceRepository
import com.iulian.iancu.spacetracker.ui.main.MainViewModel

class MainViewModelFactory constructor(
    private val repository: SpaceRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}