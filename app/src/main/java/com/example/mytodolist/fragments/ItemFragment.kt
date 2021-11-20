package com.example.mytodolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mytodolist.R
import com.example.mytodolist.databinding.FragmentAddTaskBinding
import com.example.mytodolist.databinding.ItemListBinding
import com.example.mytodolist.viewmodel.TaskViewModel


class ItemFragment : Fragment() {
     var binding: ItemListBinding? = null
    val cal = ""
    private val sharedViewModel: TaskViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myBinding = ItemListBinding.inflate(inflater, container, false)
        binding = myBinding
        return myBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {

            this!!.lifecycleOwner = viewLifecycleOwner
            itemFragment = this@ItemFragment
            viewModel = sharedViewModel
        }


    }

//    fun theAddedItems() {
//
////        val title = binding.etTitle.text.toString()
////        val date =binding.tvDate.text.toString()
////        val details =binding.etDetails.text.toString()
////        val isCompleted =binding.cbComplete.isChecked
//
//        sharedViewModel.titleSaving(title,date,details,isCompleted)
//
//
//        val action = AddFragmentDirections.actionAddFragmentToTaskFragment()
//        findNavController().navigate(action)
//
//    }
}