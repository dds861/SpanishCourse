package com.dd.spanishcourse.ui.lessonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dd.spanishcourse.data.db.entities.LessonEntity
import com.dd.spanishcourse.data.repository.DatabaseRepository

class LessonListViewModel(private val repository: DatabaseRepository) : ViewModel() {

    fun getLessons(level: Int): LiveData<List<LessonEntity>> {
        return repository.getLessonList(level).asLiveData()
    }
}