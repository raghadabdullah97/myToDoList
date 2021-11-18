package com.example.mytodolist.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mytodolist.databinding.FragmentDetailsPageBinding
import java.util.*
import android.app.TimePickerDialog
import androidx.navigation.fragment.findNavController
import com.example.mytodolist.data.delete
import com.example.mytodolist.data.edit


class DetailsPageFragment : Fragment() {
    val args: DetailsPageFragmentArgs by navArgs()
    lateinit var details: String
    private var _binding: FragmentDetailsPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("TAG", "DetailsPageFragment: ${args.task}")

        binding.apply {
            etDetails.setText(args.task.details)
            etTitle.setText(args.task.title)
            cbComplete.isChecked = args.task.isCompleted
            tvDate.text = args.task.date.getFormatDate()
            tvShoCalnder.setOnClickListener {
                setDate()
            }

            btnSave.setOnClickListener {
                val action =
                    DetailsPageFragmentDirections.actionDetailsPageFragmentToTaskFragment()
                findNavController().navigate(action)
                args.task.details = etDetails.text.toString()
                args.task.title = etTitle.text.toString()
                args.task.isCompleted = cbComplete.isChecked

                edit(args.task)
            }
            imgDelete.setOnClickListener {
                delete(args.task)
                val action =
                    DetailsPageFragmentDirections.actionDetailsPageFragmentToTaskFragment()
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

                args.task.date = calendarDate.time.time
                binding.tvDate.text = args.task.date.getFormatDate()
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