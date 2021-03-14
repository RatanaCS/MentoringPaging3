package com.sumuzu.mentoringpaging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumuzu.mentoringpaging3.databinding.ItemLoadingBinding

class PlayerLoadStateAdapter(val retry : () -> Unit ) :LoadStateAdapter<PlayerLoadStateAdapter.PlayerLoadStateViewHolder>() {
    class PlayerLoadStateViewHolder(var binding: ItemLoadingBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(loadState: LoadState) {
            binding.progressBar.isVisible = loadState is LoadState.Loading

//            if(loadState is LoadState.Error){
//                retry
//            }

        }

    }

    override fun onBindViewHolder(holder: PlayerLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): PlayerLoadStateViewHolder {

        val binding =ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PlayerLoadStateViewHolder(binding)

    }
}