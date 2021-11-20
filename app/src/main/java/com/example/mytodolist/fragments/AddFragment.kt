package com.example.mytodolist.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytodolist.R
import com.example.mytodolist.adapter.ItemAdapter
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.databinding.FragmentAddTaskBinding
import com.example.mytodolist.databinding.FragmentTaskBinding
import com.example.mytodolist.viewmodel.TaskViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment(R.layout.fragment_add_task) {

    lateinit var binding: FragmentAddTaskBinding
val cal = ""
    private val sharedViewModel: TaskViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddTaskBinding.bind(view)


        binding.apply {
            viewModel = sharedViewModel
           lifecycleOwner = viewLifecycleOwner
            addFragment = this@AddFragment
        }


    }

    fun theAddedItems() {

            val title = binding.etTitle.text.toString()
            val date =binding.tvDate.text.toString()
            val details =binding.etDetails.text.toString()
            val isCompleted =binding.cbComplete.isChecked

        sharedViewModel.titleSaving(title,date,details,isCompleted)


            val action = AddFragmentDirections.actionAddFragmentToTaskFragment()
            findNavController().navigate(action)

        }
    }


//    private fun setDate() {
//        val datePicker = MaterialDatePicker.Builder.datePicker()
//            .setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//            .build()
//
//        datePicker.show(parentFragmentManager, "DatePicker")
//        datePicker.addOnPositiveButtonClickListener {
//
//            val cal = readDate(it, "dd/MM/yyyy")
//            binding.tvDate.setText(cal)
//
//        }




//    private fun readDate(setDate: Long, datePattern: String): String {
//        val format = SimpleDateFormat(datePattern, Locale.getDefault())
//        return format.format(Date(setDate))
//
//
//    }


