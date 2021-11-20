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
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mytodolist.viewmodel.TaskViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat


class DetailsPageFragment : Fragment() {
//    val args: DetailsPageFragment by navArgs()
//    lateinit var details: String
    val cal = ""
    private var binding: FragmentDetailsPageBinding? = null
//    private val binding get() = _binding!!

    private val sharedViewModel: TaskViewModel by activityViewModels()

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


        }
    }

    fun showDatePicker() {

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()
        datePicker.show(parentFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {

           val  cal = readDate(it, "dd/MM/yyyy")
            binding?.tvShoCalnder?.setText(cal)

        }

    }
    private fun readDate (setDate: Long, datePattern: String): String{
        val format = SimpleDateFormat(datePattern, Locale.getDefault())
        return format.format(Date(setDate))

    }


//    fun edit(){
//
//        val title = binding.titletask1.text
//        val decript = binding.decript1.text
//        val date = binding.setDate1.text
//        val done = binding.checkBox2.isChecked
//        var temp = 0
//        arguments?.let {
//            temp=it.getInt("index")
//        }
//        sharedViewModel.edit(temp,tasksData(title,decript,date,done))
//        findNavController().navigate(R.id.action_edit_To_lists)
//    }




    override fun onDestroy()
    {
        super.onDestroy()
        binding = null
    }
    }
