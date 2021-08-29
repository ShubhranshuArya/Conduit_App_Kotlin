package com.example.realworldconduitapp.ui.feed.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.realworldconduitapp.databinding.FragmentAuthBinding
import com.google.android.material.tabs.TabLayout

class AuthFragment: Fragment() {

    private var _binding: FragmentAuthBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAuthBinding.inflate(inflater, container, false)

        _binding?.authTabLayout?.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null //This won't let the memory to leak
    }

}