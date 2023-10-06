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
class DetailPageViewModel @Inject constructor(var toDoRepo: ToDoRepository) : ViewModel() {

    fun deletToDo(toDo: ToDoModel) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepo.deleteToDo(toDo.todo_id)
        }
    }

    fun updateToDo(toDo: ToDoModel) {
        CoroutineScope(Dispatchers.Main).launch {
            toDoRepo.updateToDo(toDo)
        }
    }

}