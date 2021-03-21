package com.dd.spanishcourse.ui.level

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dd.spanishcourse.R
import com.dd.spanishcourse.data.db.entities.LessonEntity

class LevelViewHolder(
    itemView: View,
    navigate: (LevelName: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val TAG = "HospitalViewHolder"

    private var LessonEntity: LessonEntity = LessonEntity()

    private val tvLevel = itemView.findViewById<TextView>(R.id.tvLevel)

    companion object {
        fun create(
            parent: ViewGroup,
            navigate: (LevelName: Int) -> Unit
        ): LevelViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_level_item, parent, false)

            return LevelViewHolder(view, navigate)
        }
    }

    init {
        tvLevel.setOnClickListener { invokeNavigation(navigate) }
        itemView.rootView.setOnClickListener { invokeNavigation(navigate) }

    }

    private fun invokeNavigation(navigate: (levelName: Int) -> Unit) {
        navigate.invoke(LessonEntity.level)
    }


    fun bind(LessonEntity: LessonEntity) {
        this.LessonEntity = LessonEntity
        tvLevel.text = "${LessonEntity.level} level"
    }
}