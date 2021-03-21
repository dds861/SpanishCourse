package com.dd.spanishcourse.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dd.smartwallet.utils.Constants


@Entity(tableName = LevelEntity.TABLE_NAME)
data class LevelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID) val id: Int = 0,
    @ColumnInfo(name = LEVEL) val level: Int = 0
) {
    //////////////////////////TABLE///////////////////////////
    companion object {
        const val TABLE_NAME = "level_table"
        const val ID = "id"
        const val LEVEL = "level"

    }
    //////////////////////////////////////////////////////////
}