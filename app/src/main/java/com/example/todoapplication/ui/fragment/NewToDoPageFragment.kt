package com.example.todoapplication.ui.fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapplication.data.entitiy.ToDoModel
import com.example.todoapplication.databinding.FragmentNewToDoPageBinding
import com.example.todoapplication.ui.viewmodel.HomepageViewModel
import com.example.todoapplication.ui.viewmodel.NewToDoPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class NewToDoPageFragment : Fragment() {

    private lateinit var viewModel: NewToDoPageViewModel
    private lateinit var binding: FragmentNewToDoPageBinding
    private var selectedDate: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewToDoPageBinding.inflate(layoutInflater)
        val tempViewModel: NewToDoPageViewModel by viewModels()
        viewModel = tempViewModel

        buttonClickListeners()
        observer()

        return binding.root
    }

    fun buttonClickListeners() {

        binding.buttonSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireContext(), DatePickerDialog.OnDateSetListener
                { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                    selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    binding.textViewSelectDate.text = "$selectedDate"
                }, year, month, day
            )
            datePickerDialog.show()
        }

        binding.buttonSave.setOnClickListener {
            var toDoObject = ToDoModel(
                0,
                "${binding.editTextTitle.text}",
                "${binding.editTextBody.text}",
                "1696551500"
            )
            if (binding.textViewSelectDate.text == "Date not selected") {
                Toast.makeText(requireContext(), "Select date", Toast.LENGTH_SHORT).show()
            } else {

                toDoObject.todo_date = convertTimeStramp(binding.textViewSelectDate.text.toString())
            }

            if (toDoObject.todo_date != "" && toDoObject.todo_body != "" && toDoObject.todo_title != "") {

                viewModel.createToDO(toDoObject)

            } else {
                Toast.makeText(requireContext(), "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun convertTimeStramp(dateString: String): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        val date = dateFormat.parse(dateString)
        val timestamp = date?.time ?: 0L
        return timestamp.toString()
    }

    fun observer(){
        viewModel.insertState.observe(viewLifecycleOwner) {
          if(it){
              Navigation.findNavController(binding.buttonSave).popBackStack()
          }else{
              Toast.makeText(requireContext(), "unsuccessful", Toast.LENGTH_SHORT).show()
          }

        }
    }

}