package com.example.tabapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tabapplication.R
import com.example.tabapplication.databinding.FragmentDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private lateinit var tabLayoutMediator: TabLayoutMediator

    //private val viewModel: DashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerDashboard.adapter =
            DashboardViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)

        val activity = requireActivity()

        tabLayoutMediator = TabLayoutMediator(binding.tabDashboard, binding.viewPagerDashboard) { tab, position ->
            when (position){
                0 -> tab.text = activity.getString(R.string.first_dashboard_tab_title)
                1 -> tab.text = activity.getString(R.string.second_dashboard_tab_title)
                2 -> tab.text = activity.getString(R.string.third_dashboard_tab_title)
            }
        }
        tabLayoutMediator.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        tabLayoutMediator.detach()
    }
}