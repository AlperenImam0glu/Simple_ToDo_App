package com.example.todoapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }


}