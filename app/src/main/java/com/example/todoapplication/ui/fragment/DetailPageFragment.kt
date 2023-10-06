package com.example.todoapplication.ui.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.databinding.FragmentDetailPageBinding
import com.example.todoapplication.ui.viewmodel.DetailPageViewModel
import com.example.todoapplication.ui.viewmodel.NewToDoPageViewModel
import com.example.todoapplication.util.dateStringToTimestamp
import com.example.todoapplication.util.timestampStringtodate
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class DetailPageFragment : Fragment() {


    private lateinit var binding: FragmentDetailPageBinding
    private lateinit var viewModel: DetailPageViewModel
    private var selectedDate: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPageBinding.inflate(layoutInflater)
        val tempViewModel: DetailPageViewModel by viewModels()
        viewModel = tempViewModel

        val bundle: DetailPageFragmentArgs by navArgs()
        val todo = bundle.todo

        binding.editTextTitle.text = Editable.Factory.getInstance().newEditable(todo.todo_title)
        binding.editTextBody.text = Editable.Factory.getInstance().newEditable(todo.todo_body)
        binding.textViewSelectDate.text = todo.todo_date.timestampStringtodate()

        buttonClickListeners(todo)

        return binding.root
    }

    fun buttonClickListeners(todo: ToDoModel) {
        binding.buttonDelete.setOnClickListener {
            viewModel.deletToDo(todo)
            Toast.makeText(requireContext(), "TODO DELETED", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }

        binding.buttonUpdate.setOnClickListener {
            val updatedToDo = ToDoModel(
                todo.todo_id,
                binding.editTextTitle.text.toString().trim(),
                binding.editTextBody.text.toString(),
                binding.textViewSelectDate.text.toString().dateStringToTimestamp()
            )
            viewModel.updateToDo(updatedToDo)
            Toast.makeText(requireContext(), "TODO UPDATED", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                    selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    binding.textViewSelectDate.text = "$selectedDate"
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

    }

}