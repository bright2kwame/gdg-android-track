package com.bright.gadsleaderboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LeadersViewPagerAdapter(fragment: AppCompatActivity) : FragmentStateAdapter(fragment) {
    private val ARG_OBJECT = "TYPE"
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment = LeaderFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position)
        }
        return fragment
    }

}