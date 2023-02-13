package com.example.codial_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.codial_app.DB.MyDbHelper
import com.example.codial_app.R
import com.example.codial_app.adapters.MyPagerAdapter
import com.example.codial_app.databinding.FragmentGurhlarMalumaotBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class GurhlarMalumaotFragment : Fragment() {
    lateinit var binding: FragmentGurhlarMalumaotBinding
    lateinit var myPagerAdapter: MyPagerAdapter
    lateinit var list: ArrayList<String>
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGurhlarMalumaotBinding.inflate(layoutInflater)

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        list = ArrayList()
        list.add("Ochilgan guruhlar")
        list.add("Ochilayotgan gurhlar")

        myPagerAdapter = MyPagerAdapter(this)

        myDbHelper = MyDbHelper(binding.root.context)

        binding.viewPager.adapter = myPagerAdapter

        TabLayoutMediator(binding.tab,binding.viewPager){tab, position ->
            tab.text = list[position]
        }.attach()

        binding.imageAdd.visibility = View.INVISIBLE
        binding.imageAdd.setOnClickListener {
            findNavController().navigate(R.id.guruhQoshishFragment)
        }
        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == 1){
                    binding.imageAdd.visibility = View.VISIBLE
                }else{
                    binding.imageAdd.visibility = View.INVISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        return binding.root
    }
}