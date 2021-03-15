package com.sumuzu.mentoringpaging3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumuzu.mentoringpaging3.adapter.PlayerAdapter
import com.sumuzu.mentoringpaging3.adapter.PlayerLoadStateAdapter
import com.sumuzu.mentoringpaging3.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
//    private lateinit var binding : ActivityMainBinding
    private var viewModel :PlayerViewModel? = null
//    private lateinit var viewModel :PlayerViewModel
    private var adapterPlayer : PlayerAdapter? = null
//    private lateinit var adapterPlayer : PlayerAdapter
    private var adapterLoadState : PlayerLoadStateAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        adapterPlayer = PlayerAdapter()
//        adapterLoadState = PlayerLoadStateAdapter()
        viewModel?.setPlayer()

        setupAdapter()
        startJob()


    }

    private fun startJob() {

        lifecycleScope.launch {
            viewModel?.getPlayer()?.collect{
                adapterPlayer?.submitData(it)
            }
        }

    }

    private fun setupAdapter(){
        binding?.listPlayer?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
//            setHasFixedSize(true)
//            adapter = adapterPlayer

        }

//        binding?.listPlayer?.adapter = adapter?.withLoadStateFooter(
//                footer= PlayerLoadStateAdapter(){
//                    retry()
//                }
//        )

        binding?.listPlayer?.adapter = adapterPlayer

    }

    fun retry(){
//        adapterPlayer.retry()
    }

}