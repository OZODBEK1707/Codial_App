package com.example.codial_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.Models.Mentor
import com.example.codial_app.Models.MyObject
import com.example.codial_app.databinding.FragmentMentorRoyhatMalumotBinding

class MentorRoyhatMalumotFragment : Fragment() {
    lateinit var binding: FragmentMentorRoyhatMalumotBinding
    lateinit var myDbHelper: MyDbHelper
    lateinit var list: ArrayList<Mentor>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMentorRoyhatMalumotBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        list = ArrayList()

        for (i in myDbHelper.getMentor()){
            if (i.mycoure == MyObject.position){
                list.add(i)
            }
        }
                binding.txt1.text = objmentor.fam
                binding.txt2.text = objmentor.ism
                binding.txt3.text = objmentor.number

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}