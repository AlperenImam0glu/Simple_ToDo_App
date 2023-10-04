package com.example.todoapplication.data.entitiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable


@Entity(tableName = "todo")
data class ToDoModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id") @NotNull var todo_id: Int,
    @ColumnInfo(name = "todo_title") @NotNull var todo_title: String,
    @ColumnInfo(name = "todo_body") @NotNull var todo_body: String,
    @ColumnInfo(name = "todo_date") @NotNull var todo_date: String
) : Serializable {

}