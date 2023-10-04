package com.example.todoapplication.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapplication.data.entitiy.ToDoModel

@Dao
interface ToDoDAO {

    @Query("SELECT * FROM todo")
    suspend fun getTodoList(): List<ToDoModel>

    @Insert
    suspend fun kaydet(kisi: ToDoModel)

    @Update
    suspend fun guncelle(kisi: ToDoModel)

    @Delete
    suspend fun sil(kisi: ToDoModel)

    @Query("Select * FROM todo WHERE todo_title like '%'||:aramaKelimesi||'%'")
    suspend fun ara(aramaKelimesi: String): List<ToDoModel>
}