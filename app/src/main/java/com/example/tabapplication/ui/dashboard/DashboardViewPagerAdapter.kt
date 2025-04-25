package com.example.tabapplication.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tabapplication.ui.dashboard.subFragments.FirstDashboardFragment
import com.example.tabapplication.ui.dashboard.subFragments.SecondDashboardFragment
import com.example.tabapplication.ui.dashboard.subFragments.ThirdDashboardFragment

class DashboardViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = listOf(
        FirstDashboardFragment.newInstance(),
        SecondDashboardFragment.newInstance(),
        ThirdDashboardFragment.newInstance()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment = fragments[position]
}