package com.sumuzu.mentoringpaging3.network

import com.sumuzu.mentoringpaging3.model.Players
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/players")
    suspend fun getPlayer(
        @Query("page") page : Int,
        @Query("per_page") per_page : Int
    ) : Players

}