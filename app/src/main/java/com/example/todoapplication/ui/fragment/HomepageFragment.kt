package com.example.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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
        /* var arrayList = ArrayList<ToDoModel>()
         val t1 = ToDoModel(1,"aaaaa","aaaaaa","3/10/2023")
         val t2 = ToDoModel(2,"bbbbb","aabbbaabbbbaa","14/8/2023")
         arrayList.add(t1)
         arrayList.add(t2)
         var adapter = TodoAdapter(requireContext(),arrayList)

         binding.rv.layoutManager= LinearLayoutManager(requireContext())

         binding.rv.adapter = adapter*/

        binding.rv.layoutManager= LinearLayoutManager(requireContext())

        viewModel.todoList.observe(viewLifecycleOwner) { todoList ->
            val kisilerAdaper = TodoAdapter(requireContext(), todoList)

            binding.rv.adapter = kisilerAdaper
        }

        return binding.root
    }

}