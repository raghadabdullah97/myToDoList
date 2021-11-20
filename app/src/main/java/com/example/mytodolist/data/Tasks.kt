package com.example.mytodolist.data

data class Tasks(
    var title: String = "",
    var date: String = "",
    var details: String= "",
    var importantanty : Boolean = false,
    var isCompleted: Boolean = false,
)