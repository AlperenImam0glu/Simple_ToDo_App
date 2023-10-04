package com.example.todoapplication.di

import android.content.Context
import androidx.room.Room
import com.example.todoapplication.data.datasource.ToDoDataSource
import com.example.todoapplication.data.repo.ToDoRepository
import com.example.todoapplication.data.room.Database
import com.example.todoapplication.data.room.ToDoDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDoRepository(ToDoDS: ToDoDataSource): ToDoRepository {
        return ToDoRepository(ToDoDS)
    }


    @Provides
    @Singleton
    fun provideToDoDataSource(toDoDs: ToDoDAO): ToDoDataSource {
        return ToDoDataSource(toDoDs)
    }

    @Provides
    @Singleton
    fun provideToDoDataAccessObject(@ApplicationContext context: Context): ToDoDAO {
        val db = Room.databaseBuilder(context, Database::class.java, "todos.sqlite")
            .createFromAsset("todos.sqlite").build()
        return db.getToDoDao()
    }
}