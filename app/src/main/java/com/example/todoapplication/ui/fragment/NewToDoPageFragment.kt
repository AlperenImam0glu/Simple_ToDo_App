package com.example.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapplication.databinding.FragmentNewToDoPageBinding

class NewToDoPageFragment : Fragment() {


        private lateinit var binding: FragmentNewToDoPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewToDoPageBinding.inflate(layoutInflater)
        return binding.root
    }


}