package com.example.todoapplication.ui.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.todoapplication.databinding.FragmentNewToDoPageBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NewToDoPageFragment : Fragment() {


    private lateinit var binding: FragmentNewToDoPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewToDoPageBinding.inflate(layoutInflater)

        binding.buttonSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                    val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        return binding.root
    }

}