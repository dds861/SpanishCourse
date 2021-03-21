package com.dd.spanishcourse.ui.lesson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.spanishcourse.data.repository.DatabaseRepository

class LessonViewModelFactory(
    private val databaseRepository: DatabaseRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LessonViewModel::class.java)) {
            LessonViewModel(databaseRepository) as T
        } else super.create(modelClass)
    }
}