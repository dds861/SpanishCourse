package com.dd.spanishcourse.data.db

import androidx.room.Dao
import androidx.room.Query
import com.dd.spanishcourse.data.db.entities.LessonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {


    @Query("SELECT * FROM lesson_table ORDER BY id")
    fun getLevels(): Flow<List<LessonEntity>>


    @Query("SELECT * FROM lesson_table WHERE level =:level ORDER BY id")
    fun getLessons(level: Int): Flow<List<LessonEntity>>

    @Query("SELECT * FROM lesson_table WHERE level =:level AND lesson =:lessonList  ORDER BY id")
    fun getLessonsFiltered(level: Int, lessonList: Int): Flow<List<LessonEntity>>

    @Query("SELECT * FROM lesson_table WHERE level =:level ORDER BY id")
    fun getLessonList(level: Int): Flow<List<LessonEntity>>


}