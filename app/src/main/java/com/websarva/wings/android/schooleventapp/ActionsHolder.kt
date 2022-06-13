package com.websarva.wings.android.schooleventapp;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

class ActionsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val time: TextView? = itemView.findViewById<TextView>(R.id.time)
    val title: TextView? = itemView.findViewById<TextView>(R.id.title)
    val place: TextView? = itemView.findViewById<TextView>(R.id.place)
}