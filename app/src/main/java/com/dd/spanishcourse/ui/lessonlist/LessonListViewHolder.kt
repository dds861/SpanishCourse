package com.dd.spanishcourse.ui.lessonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dd.spanishcourse.R
import com.dd.spanishcourse.data.db.entities.LessonEntity

class LessonListViewHolder(
    itemView: View,
    navigate: (LevelName: Int, lessonList: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val TAG = "HospitalViewHolder"

    private var LevelEntity: LessonEntity = LessonEntity()

    private val tvItem = itemView.findViewById<TextView>(R.id.tvItem)

    companion object {
        fun create(
            parent: ViewGroup,
            navigate: (LevelName: Int, lessonList: Int) -> Unit
        ): LessonListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_lesson_list_item, parent, false)

            return LessonListViewHolder(view, navigate)
        }
    }

    init {
        tvItem.setOnClickListener { invokeNavigation(navigate) }
        itemView.rootView.setOnClickListener { invokeNavigation(navigate) }

    }

    private fun invokeNavigation(navigate: (levelName: Int, lessonList: Int) -> Unit) {
        navigate.invoke(LevelEntity.level, LevelEntity.lesson)
    }


    fun bind(entity: LessonEntity) {
        this.LevelEntity = entity
        tvItem.text = "${entity.lesson} lesson"
    }
}