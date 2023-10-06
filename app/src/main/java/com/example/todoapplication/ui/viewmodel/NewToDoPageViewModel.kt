package com.example.todoapplication.ui.viewmodel

import android.util.Log
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
class NewToDoPageViewModel @Inject constructor(var toDoRepo: ToDoRepository) : ViewModel() {

    val insertState = MutableLiveData<Boolean>()
    fun createToDO(toDo: ToDoModel) {
        CoroutineScope(Dispatchers.Main).launch {
           var returnType= toDoRepo.createToDo(toDo)
            if(returnType == -1L ){
                insertState.value = false
            }else{
                insertState.value = true
            }
        }
    }

}