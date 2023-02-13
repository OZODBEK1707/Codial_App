package com.example.codial_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codial_app.Models.Kurslar
import com.example.codial_app.R
import com.example.codial_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.kurslar.setOnClickListener {
            findNavController().navigate(R.id.kurslarFragment)
        }

        binding.guruhlar.setOnClickListener {
            findNavController().navigate(R.id.guruhlarFragment)
        }

        binding.mentorlar.setOnClickListener {
            findNavController().navigate(R.id.mentorlarFragment)
        }

        return binding.root
    }
}

object codial{
    var position = 0
    var kurslar = Kurslar()
    var list = ArrayList<Kurslar>()
}