package com.dd.spanishcourse.ui.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dd.spanishcourse.data.db.entities.LessonEntity
import com.dd.spanishcourse.data.repository.DatabaseRepository

class LessonViewModel(private val repository: DatabaseRepository) : ViewModel() {


    fun getLessons(level: Int, lessonList: Int): LiveData<List<LessonEntity>> {
        return repository.getLessonsFiltered(level, lessonList).asLiveData()
    }
}