package com.bright.gadsleaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class LeadersFragmentAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    private val ARG_OBJECT = "TYPE"
    override fun getItemCount(): Int = 100

    override fun createFragment(position: Int): Fragment {
        val fragment = LeaderFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position)
        }
        return fragment
    }
}