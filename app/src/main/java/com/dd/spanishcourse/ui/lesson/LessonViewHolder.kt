package com.dd.spanishcourse.ui.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dd.spanishcourse.R
import com.dd.spanishcourse.data.db.entities.LessonEntity

class LessonViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {


    private var lessonEntity: LessonEntity = LessonEntity()

    private val tvEnglishVersion = itemView.findViewById<TextView>(R.id.tvEnglishVersion)
    private val tvSpanishVersion = itemView.findViewById<TextView>(R.id.tvSpanishVersion)

    companion object {
        fun create(parent: ViewGroup): LessonViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_lesson_item, parent, false)

            return LessonViewHolder(view)
        }
    }

    init {
        tvEnglishVersion.setOnClickListener { }
        itemView.rootView.setOnClickListener { }

    }


    fun bind(LessonEntity: LessonEntity) {
        this.lessonEntity = LessonEntity
        tvEnglishVersion.text = LessonEntity.english
        tvSpanishVersion.text = LessonEntity.spanish
    }
}