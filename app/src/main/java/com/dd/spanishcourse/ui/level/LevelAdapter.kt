package com.dd.spanishcourse.ui.level

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dd.spanishcourse.data.db.entities.LessonEntity


class LevelAdapter(private val navigate: (levelName: Int) -> Unit) :
    ListAdapter<LessonEntity, LevelViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        return LevelViewHolder.create(parent, navigate)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
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