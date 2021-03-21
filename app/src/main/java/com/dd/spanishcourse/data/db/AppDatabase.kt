package com.dd.spanishcourse.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dd.spanishcourse.data.db.entities.LessonEntity
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [LessonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context, coroutineScope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "spanishcourse"
                )
                    .createFromAsset("database/spanishcourse.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}