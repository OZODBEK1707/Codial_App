package com.example.codial_app.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.Models.Kurslar
import com.example.codial_app.Models.MyObject
import com.example.codial_app.R
import com.example.codial_app.adapters.KurslarAdapter
import com.example.codial_app.databinding.FragmentMentorlarBinding


class MentorlarFragment : Fragment() {
    lateinit var binding : FragmentMentorlarBinding
    lateinit var kurslarAdapter: KurslarAdapter
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMentorlarBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        kurslarAdapter = KurslarAdapter(myDbHelper.getKurslar(),object : KurslarAdapter.RvClick{
            override fun kurslarRvClick(kurslar: Kurslar, position: Int) {
                MyObject.kurslar = kurslar
                MyObject.position = position
                findNavController().navigate(R.id.mentorlarRoyhatFragment)
            }
        })

        binding.rvMentorlar.adapter = kurslarAdapter

        return binding.root
    }
}