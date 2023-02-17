package com.artonov.retrofit.api

import com.artonov.retrofit.model.ResponseMorty
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getMorty(): Call<ResponseMorty>
}