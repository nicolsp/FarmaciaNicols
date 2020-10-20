package com.example.farmacianicols.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val URL_BASE = "https://farmanet.minsal.cl/index.php/ws/"
    fun getoRetrofitCliente() : FarmaciaApi {
        val mRetrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return mRetrofit.create(FarmaciaApi::class.java)
    }

    }


}