package com.example.farmacianicols.network

import com.example.farmacianicols.pojos.FarmaciaEntityItem
import retrofit2.Call
import retrofit2.http.GET

interface FarmaciaApi {

    @GET("getLocalesTurnos")
   suspend fun fetAllFarmacia(): Call<List<FarmaciaEntityItem>>

}