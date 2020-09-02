package com.bright.gadsleaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bright.gadsleaderboard.adapter.LeaderItemFeedAdapter
import com.bright.gadsleaderboard.data.LeaderItem
import com.bright.gadsleaderboard.retrofit.ApiUrls
import com.bright.gadsleaderboard.retrofit.ServiceBuilder

class LeaderFragment : Fragment() {
    private val ARG_OBJECT = "TYPE"
    private val BASE_URL = "https://gadsapi.herokuapp.com/"

    private lateinit var adapter: LeaderItemFeedAdapter
    private lateinit var items: ArrayList<LeaderItem>
    private val retrofit = ServiceBuilder(BASE_URL).buildService(ApiUrls::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.leader_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val type = getInt(ARG_OBJECT)
        }
        items = ArrayList<LeaderItem>()
        adapter = LeaderItemFeedAdapter(activity!!, items)



    }
}