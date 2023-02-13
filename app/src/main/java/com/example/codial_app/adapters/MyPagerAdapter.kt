package com.example.codial_app.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.codial_app.Fragments.ViewPagerFragment
import com.example.codial_app.Fragments.ViewPagerFragment2

class MyPagerAdapter  (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ViewPagerFragment()
            else -> ViewPagerFragment2()
        }
    }
}