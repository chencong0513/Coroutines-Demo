package com.njp.coroutinesdemo.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object NetworkService {

    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().callTimeout(20, TimeUnit.SECONDS).build())
        .baseUrl("https://www.dmoe.cc/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create<ApiService>()

}