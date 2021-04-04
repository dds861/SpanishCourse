package com.dd.spanishcourse.ui.lesson

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import com.dd.spanishcourse.R
import com.dd.spanishcourse.data.db.entities.LessonEntity

class LessonViewHolder(
    itemView: View,
    listener: (lessonEntity: LessonEntity) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val TAG = "LessonViewHolder"
    private var lessonEntity: LessonEntity = LessonEntity()

    private val tvEnglishVersion = itemView.findViewById<TextView>(R.id.tvEnglishVersion)
    private val tvSpanishVersion = itemView.findViewById<TextView>(R.id.tvSpanishVersion)
    private val motionLayout = itemView.findViewById<MotionLayout>(R.id.motionLayout)
    private val ivCheck = itemView.findViewById<ImageView>(R.id.ivCheck)

    companion object {
        fun create(
            parent: ViewGroup,
            navigate: (lessonEntity: LessonEntity) -> Unit
        ): LessonViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_lesson_item, parent, false)

            return LessonViewHolder(view, navigate)
        }
    }

    init {
        tvEnglishVersion.setOnClickListener {
            Log.i(TAG, "tvEnglishVersion.setOnClickListener")
            invokeChecked(listener)
        }
        tvSpanishVersion.setOnClickListener {
            Log.i(TAG, "tvSpanishVersion.setOnClickListener")
            invokeChecked(listener)
        }
        itemView.rootView.setOnClickListener {
            Log.i(TAG, "itemView.rootView")
            invokeChecked(listener)
        }


    }

    private fun invokeChecked(listener: (lessonEntity: LessonEntity) -> Unit) {
        listener.invoke(lessonEntity.copy(checked = true))
    }

    fun bind(LessonEntity: LessonEntity) {
        this.lessonEntity = LessonEntity
        tvEnglishVersion.text = LessonEntity.english
        tvSpanishVersion.text = LessonEntity.spanish
       if (LessonEntity.checked) motionLayout.transitionToEnd() else motionLayout.transitionToStart()
    }


}