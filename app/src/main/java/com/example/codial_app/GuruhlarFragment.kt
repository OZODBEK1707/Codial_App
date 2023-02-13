package com.example.codial_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.Models.Kurslar
import com.example.codial_app.Models.MyObject
import com.example.codial_app.adapters.KurslarAdapter
import com.example.codial_app.databinding.FragmentGuruhlarBinding


class GuruhlarFragment : Fragment() {
    lateinit var binding: FragmentGuruhlarBinding
    lateinit var guruhlarAdapter : KurslarAdapter
    lateinit var myDbHelper : MyDbHelper
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGuruhlarBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)
            binding.back.setOnClickListener {
                findNavController().popBackStack()
            }

        guruhlarAdapter = KurslarAdapter(myDbHelper.getKurslar(), object : KurslarAdapter.RvClick{
            override fun kurslarRvClick(kurslar: Kurslar, position: Int) {
                MyObject.position = position
                findNavController().navigate(R.id.gurhlarMalumaotFragment)
            }

        })
        binding.rvGurhlar.adapter = guruhlarAdapter

        return binding.root
    }


}