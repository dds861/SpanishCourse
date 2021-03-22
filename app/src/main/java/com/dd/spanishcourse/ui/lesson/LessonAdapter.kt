package com.dd.spanishcourse.ui.lesson

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dd.spanishcourse.data.db.entities.LessonEntity


class LessonAdapter(private val listener: (lessonEntity: LessonEntity) -> Unit) :
    ListAdapter<LessonEntity, LessonViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LessonEntity>() {
            override fun areItemsTheSame(
                oldItem: LessonEntity,
                newItem: LessonEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: LessonEntity,
                newItem: LessonEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}