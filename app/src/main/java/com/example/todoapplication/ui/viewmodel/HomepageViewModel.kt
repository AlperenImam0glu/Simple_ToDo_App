package com.example.todoapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomepageViewModel@Inject constructor(var toDoRepo :ToDoRepository) : ViewModel() {

    val todoList = MutableLiveData<List<ToDoModel>>()

    init {
        getTodoList()
    }


    fun getTodoList() {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value=  toDoRepo.getTodoList()
        }
    }

    fun searchToDo(searchString:String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value=  toDoRepo.searchToDo(searchString)
        }
    }

}