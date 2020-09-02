package com.bright.gadsleaderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import kotlinx.android.synthetic.main.toolbar_main.toolbarHome

class Main : AppCompatActivity() {

    private lateinit var leadersFragmentAdapter: LeadersViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbarHome)
        supportActionBar?.title = ""


        leadersFragmentAdapter = LeadersViewPagerAdapter(this)
        viewpager.adapter = leadersFragmentAdapter

        TabLayoutMediator(tab, viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = getString(R.string.learning_leaders)
                    }
                    1 -> {
                        tab.text = getString(R.string.learning_iq)
                    }
                }
            }).attach()

        buttonSubmit.setOnClickListener {
            startActivity(Intent(this, SubmitProject::class.java))
        }
    }
}