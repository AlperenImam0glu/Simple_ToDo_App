package com.example.todoapplication.data.repo

import com.example.todoapplication.data.datasource.ToDoDataSource

class ToDoRepository(var toDoDataSource:ToDoDataSource) {

    suspend fun getTodoList() = toDoDataSource.getTodoList()
}