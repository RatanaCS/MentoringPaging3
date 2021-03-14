package com.sumuzu.mentoringpaging3.network

import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://www.balldontlie.io/api/"

class ModuleNetwork {

    companion object{
        fun getInterceptor():OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return client
        }

        fun getService():ApiService{

            return Retrofit.Builder()
                .client(getInterceptor())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
        }

    }

}