package com.dd.spanishcourse.ui.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dd.spanishcourse.CourseApplication
import com.dd.spanishcourse.databinding.FragmentLessonBinding


class LessonFragment : Fragment() {


    private val args: LessonFragmentArgs by navArgs()
    private lateinit var binding: FragmentLessonBinding
    private val viewModel: LessonViewModel by activityViewModels {
        LessonViewModelFactory(
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
        val adapter = LessonAdapter()
        setupRecyclerView(adapter)



        viewModel.getLessons(args.level).observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

    }

    private fun setupRecyclerView(adapter: LessonAdapter) {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}