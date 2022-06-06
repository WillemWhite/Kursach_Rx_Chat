package com.example.kursach

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kursach.databinding.RoomItemBinding

class RoomsViewHolder(private val binding: RoomItemBinding) :
        RecyclerView.ViewHolder(binding.root)  {
        fun bind(item: Room, listener: OnItemClickInterface) {
            binding.model = item
            binding.root.setOnClickListener{
                listener.OnItemClickListener(item)
            }
            binding.profileImage.setImageResource(item.imageRes)
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup) : RoomsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding : RoomItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.room_item, parent,false)
                return RoomsViewHolder(binding)
            }
        }
    }