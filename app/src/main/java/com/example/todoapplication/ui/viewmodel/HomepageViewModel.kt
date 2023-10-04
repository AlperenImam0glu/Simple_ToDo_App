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


    /*
        val datePicker = binding.datePicker
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            val date = SimpleDateFormat("dd-MM-yyyy").parse("$day-$month-$year")
            Toast.makeText(this@MainActivity,    date.time.toString(), Toast.LENGTH_SHORT).show()

        }
     */
}