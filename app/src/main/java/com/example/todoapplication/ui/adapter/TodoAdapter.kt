package com.example.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.databinding.TodoItemBinding

class TodoAdapter(val mContext: Context, val todoList: List<ToDoModel>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val binding =  holder.binding
        binding.textVievTitle.text = todoList[position].todo_title
        binding.textViewBody.text = todoList[position].todo_body
        binding.textViewDate.text = todoList[position].todo_date
    }
}