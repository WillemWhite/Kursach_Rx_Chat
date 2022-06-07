package com.example.kursach

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RoomsAdapter (private var listener: OnItemClickInterface)
        : RecyclerView.Adapter<RoomsViewHolder>() {
        var data : List<Room> = emptyList()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RoomsViewHolder = RoomsViewHolder.create(parent)

        override fun getItemCount(): Int = data.size

        override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) = holder.bind(data[position], listener)
}