package com.websarva.wings.android.schooleventapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ActionsAdapter(private val data: List<ListItem>):
RecyclerView.Adapter<ActionsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsHolder {
        return ActionsHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.actions, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ActionsHolder, position: Int) {
        holder.time?.text = data[position].time
        holder.title?.text = data[position].title
        holder.place?.text = data[position].place
    }

    override fun getItemCount(): Int {
        return data.size
    }
}