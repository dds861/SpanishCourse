package com.dd.spanishcourse.ui.level

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.spanishcourse.data.repository.DatabaseRepository

class LevelViewModelFactory(
    private val databaseRepository: DatabaseRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LevelViewModel::class.java)) {
            LevelViewModel(databaseRepository) as T
        } else super.create(modelClass)
    }
}