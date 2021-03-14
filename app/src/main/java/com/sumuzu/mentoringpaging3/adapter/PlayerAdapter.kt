package com.sumuzu.mentoringpaging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.mentoringpaging3.databinding.ItemPlayerBinding
import com.sumuzu.mentoringpaging3.model.Data
//import com.sumuzu.mentoringpaging3.model.DataItem

class PlayerAdapter : PagingDataAdapter<Data, PlayerAdapter.PlayerHolder>(playerDiffUtil()) {

    //buat
    class playerDiffUtil : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {

            return oldItem == newItem
        }

    }

    //buat
    class PlayerHolder(var binding : ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Data?) {

            binding.tvFirstName.text = item?.firstName
            binding.tvLastName.text = item?.lastName
            binding.tvPosition.text = item?.position
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