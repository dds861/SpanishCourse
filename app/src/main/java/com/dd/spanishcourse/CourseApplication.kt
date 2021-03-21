package com.dd.spanishcourse

import android.app.Application
import com.dd.spanishcourse.data.db.AppDatabase
import com.dd.spanishcourse.data.repository.DatabaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CourseApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { AppDatabase.getInstance(this, applicationScope) }
    val repository by lazy { DatabaseRepository(database.appDao()) }

}