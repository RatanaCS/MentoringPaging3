package com.sumuzu.mentoringpaging3.repo

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sumuzu.mentoringpaging3.dataSource.PlayerDataSource
import com.sumuzu.mentoringpaging3.model.Data
//import com.sumuzu.mentoringpaging3.model.DataItem
import com.sumuzu.mentoringpaging3.network.ModuleNetwork
import kotlinx.coroutines.flow.Flow

class Repository {

    val api = ModuleNetwork.getService()

    fun getPlayer(): Flow<PagingData<Data>>{

        val pager = Pager(PagingConfig(pageSize = 10)){
            PlayerDataSource(api)
//            PlayerDataSource()
        }.flow

        Log.d("pager", pager.toString())

        return pager

    }
}