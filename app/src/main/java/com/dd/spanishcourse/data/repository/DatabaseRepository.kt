package com.dd.spanishcourse.data.repository

import com.dd.spanishcourse.data.db.AppDao
import com.dd.spanishcourse.data.db.entities.LessonEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DatabaseRepository(private val appDao: AppDao) {
    fun getLevels(): Flow<List<LessonEntity>> {
        return appDao.getLevels().map { list -> list.distinctBy { Pair(it.level, it.level) } }
    }

    fun getLessons(level: Int): Flow<List<LessonEntity>> {
        return appDao.getLessons(level)
    }

    fun getLessonsFiltered(level: Int, lessonList: Int): Flow<List<LessonEntity>> {
        return appDao.getLessonsFiltered(level, lessonList)
    }

    fun getLessonList(level: Int): Flow<List<LessonEntity>> {
        return appDao.getLessonList(level)
            .map { list -> list.distinctBy { Pair(it.level, it.lesson) } }
    }

}