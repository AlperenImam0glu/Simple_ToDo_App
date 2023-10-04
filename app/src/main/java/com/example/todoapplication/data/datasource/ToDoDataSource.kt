package com.example.todoapplication.data.datasource

import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.data.room.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var toDoDAO:ToDoDAO) {

    suspend fun getTodoList(): List<ToDoModel> = withContext(Dispatchers.IO) {
        return@withContext  toDoDAO.getTodoList()
    }
}