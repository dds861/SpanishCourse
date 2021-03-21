package com.dd.spanishcourse.data.db

import androidx.room.Dao
import androidx.room.Query
import com.dd.spanishcourse.data.db.entities.LessonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {


    @Query("SELECT * FROM level_table ORDER BY id")
    fun getLevels(): Flow<List<LessonEntity>>
}