package com.example.mytodolist.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Tasks(
    var title: String,
    var date: Long,
    var details: String,
    var isCompleted: Boolean,
    var creationDate: Long = Date().time,
    var id :String = UUID.randomUUID().toString(),
) : Parcelable