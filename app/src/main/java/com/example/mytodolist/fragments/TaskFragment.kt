package com.example.mytodolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytodolist.R
import com.example.mytodolist.adapter.ItemAdapter
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.data.loadTasks
import com.example.mytodolist.databinding.FragmentTaskBinding


class TaskFragment : Fragment(R.layout.fragment_task) {

    lateinit var binding: FragmentTaskBinding
    lateinit var myDataset: List<Tasks>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentTaskBinding.bind(view)
      //  args.task.
        binding.apply {
            val itemAdapter = ItemAdapter(loadTasks())
            itemAdapter.onItemClick = { task ->

                val action =
                    TaskFragmentDirections.actionTaskFragmentToDetailsPageFragment2(
                        task
                    )
                findNavController().navigate(action)
            }
            recyclerView.adapter = itemAdapter
            recyclerView.setHasFixedSize(true)


            fabAdd.setOnClickListener {
                val action = TaskFragmentDirections.actionTaskFragmentToAddFragment()
                findNavController().navigate(action)
            }

        }

    }
}








