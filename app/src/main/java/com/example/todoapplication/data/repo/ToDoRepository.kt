package com.example.todoapplication.data.repo

import com.example.todoapplication.data.datasource.ToDoDataSource
import com.example.todoapplication.data.entitiy.ToDoModel

class ToDoRepository(var toDoDataSource:ToDoDataSource) {

    suspend fun getTodoList() = toDoDataSource.getTodoList()

    suspend fun updateToDo(toDo : ToDoModel) = toDoDataSource.updateToDo(toDo)

    suspend fun deleteToDo(todo_id: Int) = toDoDataSource.deleteToDo(todo_id)

    suspend fun createToDo(toDo: ToDoModel):Long = toDoDataSource.createToDo(toDo)

    suspend fun searchToDo(searchedString: String): List<ToDoModel> = toDoDataSource.searchToDo(searchedString)
}