package com.sumuzu.mentoringpaging3

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sumuzu.mentoringpaging3.model.Data
//import com.sumuzu.mentoringpaging3.model.DataItem
import com.sumuzu.mentoringpaging3.repo.Repository
import kotlinx.coroutines.flow.Flow

class PlayerViewModel :ViewModel() {

    val repo = Repository()
    var responsePlayer : Flow<PagingData<Data>>? = null

    fun setPlayer(){
        responsePlayer= repo.getPlayer().cachedIn(viewModelScope)
//        Log.d("setPlayer", responsePlayer.toString())
        Log.d("setPlayer", repo.toString())
    }

    fun getPlayer() = responsePlayer


}