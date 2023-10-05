package com.example.todoapplication.ui.fragment

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todoapplication.databinding.FragmentDetailPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPageFragment : Fragment() {


    private lateinit var binding: FragmentDetailPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPageBinding.inflate(layoutInflater)

        val bundle: DetailPageFragmentArgs by navArgs()
        val todo = bundle.todo

        binding.editTextText.text=  Editable.Factory.getInstance().newEditable(todo.todo_title)
        binding.editTextText2.text=  Editable.Factory.getInstance().newEditable(todo.todo_body)

        return binding.root
    }


}