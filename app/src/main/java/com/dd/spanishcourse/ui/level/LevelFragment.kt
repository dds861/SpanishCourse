package com.dd.spanishcourse.ui.level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dd.spanishcourse.CourseApplication
import com.dd.spanishcourse.databinding.FragmentLevelBinding


class LevelFragment : Fragment() {

    private lateinit var binding: FragmentLevelBinding
    private val viewModel: LevelViewModel by activityViewModels {
        LevelViewModelFactory(
            ((activity?.application) as CourseApplication).repository
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LevelAdapter { level -> onNavigateToLesson(level) }
        setupRecyclerView(adapter)

        viewModel.levels.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })



    }

    private fun setupRecyclerView(adapter: LevelAdapter) {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun onNavigateToLesson(level: Int) {
        val action = LevelFragmentDirections.actionLevelFragmentToLessonListFragment(level)
        NavHostFragment.findNavController(this).navigate(action)
    }

}