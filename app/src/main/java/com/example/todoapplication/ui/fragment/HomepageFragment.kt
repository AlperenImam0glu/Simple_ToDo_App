package com.example.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.databinding.FragmentHomepageBinding
import com.example.todoapplication.ui.adapter.TodoAdapter
import com.example.todoapplication.ui.viewmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding

    private lateinit var viewModel: HomepageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(layoutInflater)
        val tempViewModel: HomepageViewModel by viewModels()
        viewModel = tempViewModel
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        observer()
        buttonClickListeners()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTodoList()
    }

    fun buttonClickListeners() {
        binding.fab.setOnClickListener {
            val action = HomepageFragmentDirections.homepageToNewTodoPage()
            Navigation.findNavController(it).navigate(action)
        }

        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String?): Boolean {
                if (newText != null) {
                    searchToDo(newText)
                }
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query != null) {
                    searchToDo(query)
                }
                return false
            }
        })
    }

    fun searchToDo(searchString: String) {
        viewModel.searchToDo(searchString)
    }

    fun observer() {
        viewModel.todoList.observe(viewLifecycleOwner) { todoList ->
            val kisilerAdaper = TodoAdapter(requireContext(), todoList, viewModel)
            binding.rv.adapter = kisilerAdaper
        }
    }

}