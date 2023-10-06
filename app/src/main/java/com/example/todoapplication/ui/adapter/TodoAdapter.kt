package com.example.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.R
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.databinding.TodoItemBinding
import com.example.todoapplication.ui.fragment.HomepageFragmentDirections
import com.example.todoapplication.ui.viewmodel.HomepageViewModel
import com.example.todoapplication.util.timestampStringtodate

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
        binding.textVievTitle.text = todoList[position].todo_title
        binding.textViewBody.text = todoList[position].todo_body
        binding.textViewDate.text = todoList[position].todo_date.timestampStringtodate()
        binding.constraintLayout.setBackgroundResource(changeColor(position))
        binding.card.setOnClickListener {
            val action = HomepageFragmentDirections.homepageToDetailpage(todoList[position])
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun changeColor(position: Int): Int {
        if (position % 6 == 0) {
            return R.color.rv_item_color
        } else if (position % 6 == 1) {
            return R.color.rv_item_color1
        } else if (position % 6 == 2) {
            return R.color.rv_item_color2
        } else if (position % 6 == 3) {
            return R.color.rv_item_color3
        } else if (position % 6 == 4) {
            return R.color.rv_item_color4
        } else if (position % 6 == 5) {
            return R.color.rv_item_color5
        } else {
            return R.color.rv_item_color
        }
    }
}