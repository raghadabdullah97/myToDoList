package com.example.mytodolist.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mytodolist.R
import com.example.mytodolist.adapter.ItemAdapter
import com.example.mytodolist.data.Tasks
import com.example.mytodolist.data.addTasks
import com.example.mytodolist.databinding.FragmentAddTaskBinding
import com.example.mytodolist.databinding.FragmentTaskBinding
import java.util.*


class AddFragment : Fragment(R.layout.fragment_add_task) {
    var date = 0L
    lateinit var binding: FragmentAddTaskBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddTaskBinding.bind(view)


        binding.apply {

            btnCalender.setOnClickListener {
                setDate()
            }
            btnSave.setOnClickListener {
                val title = etTitle.text.toString()
                val details = etDetails.text.toString()
                val isCompleted = cbComplete.isChecked
                val task = Tasks(title, date, details, isCompleted)
                addTasks(task)
                val action = AddFragmentDirections.actionAddFragmentToTaskFragment()
                findNavController().navigate(action)

            }
        }

    }

    private fun setDate() {
        val calendarDate = Calendar.getInstance()

        val year: Int = calendarDate.get(Calendar.YEAR)
        val month: Int = calendarDate.get(Calendar.MONTH)
        val day: Int = calendarDate.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { view, year, monthOfYear, dayOfMonth ->
                calendarDate.set(Calendar.YEAR, year)
                calendarDate.set(Calendar.MONTH, monthOfYear)
                calendarDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                date = calendarDate.time.time
                binding.tvDate.text = date.getFormatDate()
                Log.e(
                    "setDateStart",
                    "DatePickerDialog: day $dayOfMonth month: $monthOfYear year: $year"
                )

            }, year, month, day
        )

        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000

        datePickerDialog.show()


    }
}


fun Long.getFormatDate(format: String = "yyyy-MMM-dd") =
    DateFormat.format(format, this).toString()





