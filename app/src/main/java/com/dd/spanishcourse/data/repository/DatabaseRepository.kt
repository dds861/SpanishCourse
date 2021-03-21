package com.dd.spanishcourse.data.repository

import com.dd.spanishcourse.data.db.AppDao
import com.dd.spanishcourse.data.db.entities.LessonEntity
import com.dd.spanishcourse.data.db.entities.LevelEntity
import kotlinx.coroutines.flow.Flow

class DatabaseRepository(private val appDao: AppDao) {
    fun getLevels(): Flow<List<LevelEntity>> {
        return appDao.getLevels()
    }

    fun getLessons(level: Int): Flow<List<LessonEntity>> {

        return appDao.getLessons(level)
    }

}