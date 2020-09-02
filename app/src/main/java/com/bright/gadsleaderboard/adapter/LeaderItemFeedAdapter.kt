package com.bright.gadsleaderboard.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bright.gadsleaderboard.R
import com.bright.gadsleaderboard.data.LeaderItem

/**
 * Created by Monarchy on 09/10/2017.
 */

class LeaderItemFeedAdapter(private val activity: Activity, private var items: List<LeaderItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val constant = 100

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(viewGroup.context)
        when (viewType) {
            constant -> {
                val viewHolderItem = inflater.inflate(R.layout.leader_item, viewGroup, false)
                viewHolder = LeaderItemViewHolder(viewHolderItem)
            }
        }
        return viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            constant -> {
                val leaderItemViewHolder = holder as LeaderItemViewHolder
                configureLeaderViewHolder(leaderItemViewHolder, items[position], activity)
            }
        }
    }

    override fun getItemCount(): Int {
        return this.items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            items[position] is LeaderItem -> constant
            else -> -1
        }
    }

    // MARK: configure the device
    private fun configureLeaderViewHolder(
        viewHolder: LeaderItemViewHolder,
        data: LeaderItem,
        activity: Activity
    ) {
        val parent = viewHolder.itemView
        val textViewName = viewHolder.textViewName
        val textViewLocation = viewHolder.textViewLocation
        val imageViewItem = viewHolder.imageViewItem

        textViewName?.text = data.name
        if (data.hours == 0) {
            textViewLocation?.text = "${data.score} skill IQ Score, ${data.country}."
        } else {
            textViewLocation?.text = "${data.hours} learning hours, ${data.country}."
        }
    }
}
