package com.bright.gadsleaderboard.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bright.gadsleaderboard.R

/**
 * Created by Monarchy on 09/10/2017.
 */

class LeaderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textViewName: TextView? = null
    var textViewLocation: TextView? = null
    var imageViewItem: ImageView? = null

    init {
        textViewLocation = itemView.findViewById(R.id.textViewLocation)
        textViewName = itemView.findViewById(R.id.textViewName)
        imageViewItem = itemView.findViewById(R.id.imageViewItem)
    }
}
