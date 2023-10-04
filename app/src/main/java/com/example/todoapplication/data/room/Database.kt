package com.example.todoapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapplication.data.entitiy.ToDoModel

@Database(entities = [ToDoModel ::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getToDoDao() : ToDoDAO
}