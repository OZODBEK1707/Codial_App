package com.example.codial_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.Models.MyObject
import com.example.codial_app.databinding.FragmentEditOquvchiBinding


class EditOquvchiFragment : Fragment() {
    lateinit var binding: FragmentEditOquvchiBinding
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditOquvchiBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        val list = myDbHelper.getStudent()

        binding.edtFamiliyasi.setText(list[MyObject.position].familiyasi)
        binding.edtIsmi.setText(list[MyObject.position].nomi)
        binding.edtNumber.setText(list[MyObject.position].number)

        binding.btnOk.setOnClickListener {
            val familiya = binding.edtFamiliyasi.text.toString()
            val ismi = binding.edtIsmi.text.toString()
            val number = binding.edtNumber.text.toString()
            val talaba = list[MyObject.position]
            talaba.familiyasi = familiya
            talaba.nomi = ismi
            talaba.number = number
            myDbHelper.updateStudent(talaba)
            findNavController().popBackStack()
        }

        return binding.root
    }
}