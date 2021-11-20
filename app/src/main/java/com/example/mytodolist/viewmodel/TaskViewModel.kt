package com.example.mytodolist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytodolist.data.Tasks

import com.example.mytodolist.data.tasksList

class TaskViewModel : ViewModel()  {
var _quantit = 0
 var _title = MutableLiveData<String>()
 var _date = MutableLiveData<String>()
 var _details = MutableLiveData<String>()
 var _isCompleted = MutableLiveData<Boolean>()
 var _importantanty = MutableLiveData<Boolean>()
 var compareData = MutableLiveData<Long>()

 fun newtitleSaving(title: String, date:String, detail: String, completions: Boolean ) {
  _title.value = title
  _date.value = date
  _details.value = detail
  _isCompleted.value = completions
tasksList.add(_quantit, Tasks(title = title, date = date, details = detail, isCompleted = completions))

     _quantit ++
 }


 fun settitleSaving (index: Int  ,title: String,  completions: Boolean ) {
  _title.value = title
  _isCompleted.value = completions

  tasksList.set( index, Tasks(title = title,  isCompleted = completions,))



 }

 fun setDate(date: String ){
  _date.value = date

 }

}