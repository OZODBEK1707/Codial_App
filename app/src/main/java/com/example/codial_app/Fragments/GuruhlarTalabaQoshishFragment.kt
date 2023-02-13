package com.example.codial_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.Models.Talaba
import com.example.codial_app.databinding.FragmentGuruhlarTalabaQoshishBinding

class GuruhlarTalabaQoshishFragment : Fragment() {
   lateinit var binding: FragmentGuruhlarTalabaQoshishBinding
   lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuruhlarTalabaQoshishBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        binding.saqlash.setOnClickListener {
            val familiya = binding.edtFamiliyasi.text.toString()
            val ism = binding.edtIsmi.text.toString()
            val number = binding.edtNumber.text.toString()
            val student = Talaba(
                familiya,
                ism,
                number
            )
            myDbHelper.addStudent(student)
            myDbHelper.getStudent().add(student)
            findNavController().popBackStack()
        }

        return binding.root
    }
}