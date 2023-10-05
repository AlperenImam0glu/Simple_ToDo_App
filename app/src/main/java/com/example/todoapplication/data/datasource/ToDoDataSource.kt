package com.example.todoapplication.data.datasource

import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.data.room.ToDoDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var toDoDAO: ToDoDAO) {

    suspend fun getTodoList(): List<ToDoModel> = withContext(Dispatchers.IO) {
        return@withContext toDoDAO.getTodoList()
    }

    suspend fun createToDo(newToDo: ToDoModel) {
        toDoDAO.createToDo(newToDo)
    }

    suspend fun updateToDo(newToDo: ToDoModel) {
        toDoDAO.updateToDo(newToDo)
    }

    suspend fun deleteToDo(todo_id: Int) {
        val deletedToDo = ToDoModel(todo_id, "", "", "")
        toDoDAO.deleteToDo(deletedToDo)
    }

    suspend fun searchToDo(searchedWord: String): List<ToDoModel> = withContext(Dispatchers.IO) {
        return@withContext toDoDAO.searchToDo(searchedWord)
    }
}