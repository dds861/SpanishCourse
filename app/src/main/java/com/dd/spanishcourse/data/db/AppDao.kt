package com.dd.spanishcourse.data.db

import androidx.room.Dao
import androidx.room.Query
import com.dd.spanishcourse.data.db.entities.LessonEntity
import com.dd.spanishcourse.data.db.entities.LevelEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {


    @Query("SELECT * FROM level_table ORDER BY id")
    fun getLevels(): Flow<List<LevelEntity>>


    @Query("SELECT * FROM lesson_table WHERE level =:level ORDER BY id")
    fun getLessons(level: Int): Flow<List<LessonEntity>>


}