package com.dd.spanishcourse.ui.level

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dd.spanishcourse.data.repository.DatabaseRepository

class LevelViewModel(private val repository: DatabaseRepository) : ViewModel() {

    val levels = repository.getLevels().asLiveData()

}