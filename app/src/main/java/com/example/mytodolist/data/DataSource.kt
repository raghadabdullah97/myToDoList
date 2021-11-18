package com.example.mytodolist.data


    private val tasksList = mutableListOf<Tasks>()

    fun loadTasks(): List<Tasks> {
        return tasksList
    }

    fun addTasks(tasks: Tasks){
        tasksList.add(tasks)
    }

    fun edit(tasks: Tasks){
    tasksList.replaceAll {
        tasks
    }

    }


    fun delete(tasks: Tasks){
    tasksList.removeIf {
        it.id == tasks.id
    }

    }
