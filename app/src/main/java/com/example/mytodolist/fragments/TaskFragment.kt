package com.example.mytodolist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytodolist.R
import com.example.mytodolist.adapter.ItemAdapter
import com.example.mytodolist.data.Tasks

import com.example.mytodolist.data.tasksList
import com.example.mytodolist.databinding.FragmentTaskBinding
import com.example.mytodolist.viewmodel.TaskViewModel
import javax.sql.DataSource


class TaskFragment : Fragment() {

   private var binding: FragmentTaskBinding? = null
  private val sharedViewModel: TaskViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val FragmentTaskBinding = FragmentTaskBinding.inflate(inflater, container, false)
        binding = FragmentTaskBinding
        return FragmentTaskBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       super.onViewCreated(view, savedInstanceState)
        binding?.taskFragment = this@TaskFragment
        binding?.recyclerview?.adapter = ItemAdapter(this.requireContext(), tasksList)
        binding?.recyclerview?.setHasFixedSize(true)


//        binding?.butAdd?.setOnClickListener {
//            //    val action = ListsF
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

   fun goToAddFragment() {

       findNavController().navigate(R.id.action_taskFragment_to_addFragment)

   }
}








