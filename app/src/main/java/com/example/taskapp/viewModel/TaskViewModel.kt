package com.example.taskapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskapp.model.Task

class TaskViewModel: ViewModel() {

    val taskList: MutableLiveData<List<Task>?> = MutableLiveData()

    init {
        taskList.value = listOf()
    }

    fun addTask(title: String){
        val currentList = taskList.value?.toMutableList() ?: mutableListOf()
        currentList.add(Task(title))
        taskList.value = currentList
    }

    fun markTaskAsDone(position: Int){
        val currentList = taskList.value?.toMutableList()
        currentList?.get(position)?.isDone = true
        taskList.value = currentList
    }

    fun deleteTask(position: Int){
        val tasks = taskList.value?.toMutableList()
        tasks?.removeAt(position)
        taskList.value = tasks
    }
}