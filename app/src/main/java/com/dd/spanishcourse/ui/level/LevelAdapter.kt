package com.dd.spanishcourse.ui.level

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.dd.spanishcourse.data.db.entities.LevelEntity


class LevelAdapter(private val navigate: (levelName: Int) -> Unit) :
    ListAdapter<LevelEntity, LevelViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        return LevelViewHolder.create(parent, navigate)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LevelEntity>() {
            override fun areItemsTheSame(
                oldItem: LevelEntity,
                newItem: LevelEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: LevelEntity,
                newItem: LevelEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}