package com.example.codial_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.databinding.FragmentMentorQoshishBinding

class MentorQoshishFragment : Fragment() {
    lateinit var binding : FragmentMentorQoshishBinding
    lateinit var myDbHelper : MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMentorQoshishBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        var list = myDbHelper.getMentor()

        binding.edtFamiliyasi.setText(list[objmentor.position2].familiya)
        binding.edtIsmi.setText(list[objmentor.position2].ismi)
        binding.edtNumber.setText(list[objmentor.position2].number)

        binding.btnOzgartir.setOnClickListener {
            val familiya = binding.edtFamiliyasi.text.toString()
            val ismi = binding.edtIsmi.text.toString()
            val number = binding.edtNumber.text.toString()
            if (familiya.isNotEmpty() && ismi.isNotEmpty() && number.isNotEmpty()){
                var mentor = list[objmentor.position2]
                mentor.familiya = familiya
                mentor.ismi = ismi
                mentor.number = number
                myDbHelper.updateMentor(mentor)
                findNavController().popBackStack()
            }else{
                Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}