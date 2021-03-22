package com.dd.spanishcourse.ui.lessonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dd.spanishcourse.CourseApplication
import com.dd.spanishcourse.databinding.FragmentLessonBinding


class LessonListFragment : Fragment() {
    private val args: LessonListFragmentArgs by navArgs()
    private lateinit var binding: FragmentLessonBinding
    private val viewModel: LessonListViewModel by activityViewModels {
        LessonListViewModelFactory(
            ((activity?.application) as CourseApplication).repository
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLessonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().title = "Level ${args.level}"

        val adapter =
            LessonListAdapter { level, lessonList -> onNavigateToLesson(level, lessonList) }
        setupRecyclerView(adapter)

        viewModel.getLessons(args.level).observe(viewLifecycleOwner, { list ->
            adapter.submitList(list)
        })


    }


    private fun setupRecyclerView(adapter: LessonListAdapter) {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun onNavigateToLesson(level: Int, lessonList: Int) {
        val action =
            LessonListFragmentDirections.actionLessonListFragmentToLessonFragment(level, lessonList)
        NavHostFragment.findNavController(this).navigate(action)
    }

}