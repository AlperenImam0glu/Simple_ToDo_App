package com.example.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.databinding.TodoItemBinding
import com.example.todoapplication.ui.fragment.HomepageFragmentDirections
import com.example.todoapplication.ui.viewmodel.HomepageViewModel
import java.text.SimpleDateFormat
import java.util.Date

class TodoAdapter(
    val mContext: Context,
    val todoList: List<ToDoModel>,
    val viewModel: HomepageViewModel
) :
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
        val binding = holder.binding

        val timestamp: Long = todoList[position].todo_date.toLong()
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat("dd/MM/yyyy")
        val dateString = format.format(date)

        binding.textVievTitle.text = todoList[position].todo_title
        binding.textViewBody.text = todoList[position].todo_body
        binding.textViewDate.text = "$dateString"

        binding.card.setOnClickListener {
            val action = HomepageFragmentDirections.homepageToDetailpage(todoList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }
}