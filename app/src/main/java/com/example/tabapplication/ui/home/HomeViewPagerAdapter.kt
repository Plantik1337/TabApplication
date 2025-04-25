package com.example.tabapplication.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tabapplication.ui.home.subFragment.FirstHomeFragment
import com.example.tabapplication.ui.home.subFragment.SecondHomeFragment
import com.example.tabapplication.ui.home.subFragment.ThirdHomeFragment

class HomeViewPagerAdapter(fragment: HomeFragment): FragmentStateAdapter(fragment) {

    private val fragments = listOf(
        FirstHomeFragment(),
        SecondHomeFragment(),
        ThirdHomeFragment()
    )

    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemCount(): Int = fragments.size

}