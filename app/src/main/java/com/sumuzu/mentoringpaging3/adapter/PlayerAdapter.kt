package com.sumuzu.mentoringpaging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.mentoringpaging3.databinding.ItemPlayerBinding
import com.sumuzu.mentoringpaging3.model.DataItem

class PlayerAdapter : PagingDataAdapter<DataItem, PlayerAdapter.PlayerHolder>(playerDiffUtil()) {

    //buat
    class playerDiffUtil : DiffUtil.ItemCallback<DataItem>(){
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {

            return oldItem == newItem
        }

    }

    //buat
    class PlayerHolder(var binding : ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: DataItem?) {

            binding.tvFirstName.text = item?.firstName
            binding.tvLastName.text = item?.position
            binding.tvPosition.text = item?.team?.city
        }

    }

    //implement
    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {

        holder.bind(getItem(position))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {

        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)

        return PlayerHolder(binding)

    }
}