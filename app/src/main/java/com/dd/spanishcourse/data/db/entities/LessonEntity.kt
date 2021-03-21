package com.dd.spanishcourse.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dd.smartwallet.utils.Constants.STRING_EMPTY


@Entity(tableName = LessonEntity.TABLE_NAME)
data class LessonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID) val id: Int = 0,
    @ColumnInfo(name = LEVEL) val level: Int = 0,
    @ColumnInfo(name = LESSON) val lesson: Int = 0,
    @ColumnInfo(name = SPANISH) val spanish: String = STRING_EMPTY,
    @ColumnInfo(name = ENGLISH) val english: String = STRING_EMPTY,
) {
    //////////////////////////TABLE///////////////////////////
    companion object {
        const val TABLE_NAME = "lesson_table"
        const val ID = "id"
        const val LEVEL = "level"
        const val LESSON = "lesson"
        const val SPANISH = "spanish"
        const val ENGLISH = "english"

    }
    //////////////////////////////////////////////////////////
}