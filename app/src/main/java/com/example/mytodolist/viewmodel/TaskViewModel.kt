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

 fun newtitleSaving(title: String, date:String, detail: String, completions: Boolean ) {
  _title.value = title
  _date.value = date
  _details.value = detail
  _isCompleted.value = completions
tasksList.add(_quantit, Tasks(title = title, date = date, details = detail, isCompleted = completions))

     _quantit ++
 }


 fun settitleSaving (index: Int  ,title: String, detail: String, completions: Boolean ) {
  _title.value = title
  _details.value = detail
  _isCompleted.value = completions
  tasksList[index] = Tasks(title = title, details = detail, isCompleted = completions)

 }

}