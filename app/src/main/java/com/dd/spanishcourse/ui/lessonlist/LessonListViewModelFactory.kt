package com.dd.spanishcourse.ui.lessonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.spanishcourse.data.repository.DatabaseRepository

class LessonListViewModelFactory(
    private val databaseRepository: DatabaseRepository
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LessonListViewModel::class.java)) {
            LessonListViewModel(databaseRepository) as T
        } else super.create(modelClass)
    }
}