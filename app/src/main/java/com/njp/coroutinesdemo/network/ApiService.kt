package com.njp.coroutinesdemo.network

import com.njp.coroutinesdemo.bean.ImageDataResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("random.php")
    suspend fun getImage(@Query("return") type: String = "json"): ImageDataResponseBody
}