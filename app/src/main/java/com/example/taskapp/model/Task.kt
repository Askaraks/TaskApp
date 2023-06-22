package com.example.taskapp.model

data class Task(
    val title: String,
    var isDone: Boolean = false){

    fun toggleDone(){
        isDone = !isDone
    }
}
