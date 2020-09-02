package com.bright.gadsleaderboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bright.gadsleaderboard.adapter.LeaderItemFeedAdapter
import com.bright.gadsleaderboard.data.LeaderItem
import com.bright.gadsleaderboard.retrofit.ApiUrls
import com.bright.gadsleaderboard.retrofit.ServiceBuilder
import kotlinx.android.synthetic.main.leader_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LeaderFragment : Fragment() {
    private val ARG_OBJECT = "TYPE"
    private val BASE_URL = "https://gadsapi.herokuapp.com/"
    private var callType = 0

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
            callType = getInt(ARG_OBJECT)
        }
        items = ArrayList<LeaderItem>()
        adapter = LeaderItemFeedAdapter(activity!!, items)

        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = true
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        dataProgress.visibility = View.VISIBLE

        if (callType == 0) {
            retrofit.learningLeaders().enqueue(
                handleCallBack
            )
        } else {
            retrofit.skillIQLeaders().enqueue(
                handleCallBack
            )
        }
    }

    //MARK: handle tha callback
    private var handleCallBack = object : Callback<List<LeaderItem>> {
        override fun onFailure(call: Call<List<LeaderItem>>, t: Throwable) {
            dataProgress?.visibility = View.GONE
            Log.e("ERROR", t.toString())
        }

        override fun onResponse(
            call: Call<List<LeaderItem>>,
            response: Response<List<LeaderItem>>
        ) {
            dataProgress?.visibility = View.GONE
            response.body()?.let {
                handleSuccessResponse(it)
            }
        }
    }

    private fun handleSuccessResponse(data: List<LeaderItem>) {
        items.clear()
        items.addAll(data)
        adapter.notifyDataSetChanged()
    }

    private fun handleErrorResponse() {

    }
}