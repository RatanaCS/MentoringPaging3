package com.sumuzu.mentoringpaging3.dataSource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sumuzu.mentoringpaging3.model.DataItem
import com.sumuzu.mentoringpaging3.network.ApiService
import com.sumuzu.mentoringpaging3.network.ModuleNetwork

class PlayerDataSource(var api : ApiService) : PagingSource<Int, DataItem>() {
    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {

        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {

        return try {
            //untuk ambil current page
            val nextPage =  params.key  ?: 1

            //ambil response data nya
            val response = api.getPlayer(nextPage, params.loadSize)
//            val response = ModuleNetwork.getService().getPlayer(params.loadSize, nextPage)
//            Log.d("response", response.toString())

            LoadResult.Page(
                response.data,
                prevKey = if(nextPage == 1) null else nextPage - 1,
                nextKey = if(nextPage == response.meta?.totalPages) null else nextPage + 1
            )



        }catch (e : Exception){
            LoadResult.Error(e)
        }

//        Log.d("TAG", LoadResult.Page.toString())



    }
}