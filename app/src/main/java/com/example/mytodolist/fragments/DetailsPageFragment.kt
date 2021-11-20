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
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mytodolist.R
import com.example.mytodolist.viewmodel.TaskViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Calendar.getInstance


class DetailsPageFragment : Fragment() {
//    val args: DetailsPageFragment by navArgs()
//    lateinit var details: String
var compare: Long = 0
    var myDate: String = ""
    private var binding: FragmentDetailsPageBinding? = null
//    private val binding get() = _binding!!

    private val sharedViewModel: TaskViewModel by activityViewModels()
var index = 0
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentDetailsPageBinding.inflate(inflater, container, false)
//        val view = binding.root
//        return view
//    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentDetailsPageBinding = FragmentDetailsPageBinding.inflate(inflater, container, false)
        binding = fragmentDetailsPageBinding
        return fragmentDetailsPageBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            detailFragment = this@DetailsPageFragment
        }


        arguments.let {
            binding?.etTitle?.setText(it?.getString("title"))
            binding?.cbComplete?.isChecked = it!!.getBoolean("check")
           // binding?.myIndex?.text = it.getString("index")
            index = it.getInt("index")
        }
        compareDate()
    }

    fun sendTheIndex() {
       //var index =  binding?.myIndex?.text.toString().toInt()
        println("$index")
//        println(index)
//        println(index)
//        println(index)
        val title = binding?.etTitle?.text.toString()
        val detail = binding?.etDetails?.text.toString()
        val compelation = binding?.cbComplete?.isChecked
       sharedViewModel.settitleSaving(index,title,compelation!!)

        findNavController().navigate(R.id.action_detailsPageFragment_to_taskFragment)
    }



    fun showDatePicker() {
        // prepare the calender to be selectable
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        // show it in the secreen
        datePicker.show(parentFragmentManager, "DatePicker")
        // the click of the lestiner in side the table of calender
        datePicker.addOnPositiveButtonClickListener {
            // saving the value below ( the type is long) we use it  for the comparison
            compare = it
            // here convert it to String and show it to the user to be user frindly
            myDate = convertMillisecondsToReadableDate(it, "EEE, MMM dd ")
            // we store the date in the view model
            sharedViewModel.setDate(myDate)
            // we store the comparison
            sharedViewModel.compareData.value = compare
        }
    }
       private fun convertMillisecondsToReadableDate(
            dateMilliseconds: Long,
            datePattern: String
        ): String {
            val format = SimpleDateFormat(datePattern, Locale.getDefault())
            return format.format(Date(dateMilliseconds))
        }


    fun compareDate() {
        if (sharedViewModel.compareData.value == null) {
            Toast.makeText(context,"chose Date",Toast.LENGTH_SHORT).show()
        }
        else if (sharedViewModel.compareData.value!! < getInstance().timeInMillis  ) {
            Toast.makeText(context,"the time is finished. ",Toast.LENGTH_SHORT).show()
        }
        else Toast.makeText(context,".....",Toast.LENGTH_SHORT).show()
    }




    override fun onDestroy()
    {
        super.onDestroy()
        binding = null
    }

    }
