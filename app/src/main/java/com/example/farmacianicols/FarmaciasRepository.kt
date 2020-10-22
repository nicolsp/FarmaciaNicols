package com.example.farmacianicols

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.farmacianicols.local.FarmaciasDao
import com.example.farmacianicols.local.FarmaciasUsadas
import com.example.farmacianicols.network.RetrofitClient
import com.example.farmacianicols.pojos.FarmaciaEntityItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FarmaciasRepository(private val farmaciasDao: FarmaciasDao) {
    private val Retroservice = RetrofitClient.getoRetrofitCliente()
    val mLiveData = farmaciasDao.showAllFafarmacias()

    fun obtainFarmaciasByID(id : Int): LiveData<FarmaciasUsadas> {
        return farmaciasDao.showOnFarmaciasByID(id)
    }

   // suspend fun updateFarmacias(farmaciasUsadas: FarmaciasUsadas) {
     // farmaciasDao.updateFarmacias(farmaciasUsadas)
    //}

      fun getDataFromServe() {
val call = Retroservice.fetAllFarmacia()
        call.enqueue(object : Callback<List<FarmaciaEntityItem>> {
            override fun onResponse(
                call: Call<List<FarmaciaEntityItem>>,
                response: Response<List<FarmaciaEntityItem>>
            ) {
                when(response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        Log.d("RESPONDEOKKK",response.code().toString())
                        response.body()?.let {
                            farmaciasDao.insertAllFarmacias(convert(it))
                        }
                    }
                    in 300..509 -> Log.d("RESPONSE_300",response.body().toString())
                    else -> Log.d("ERROR", response.errorBody().toString())
            }

        }

            override fun onFailure(call: Call<List<FarmaciaEntityItem>>, t: Throwable) {
               Log.e("ERROR",t.message.toString())
            }
        })

    }
    fun convert(listFromNetwor: List<FarmaciaEntityItem>): List<FarmaciasUsadas> {
        val listmjutable = mutableListOf<FarmaciasUsadas>()
        listFromNetwor.map {
            listmjutable.add(FarmaciasUsadas(it.localId,
                    it.comunaNombre,
                    it.fecha,
                    it.fkComuna,
                    it.fkLocalidad,
                    it.fkRegion,
                    it.funcionamientoDia,
                    it.localDireccion,
                    it.funcionamientoHoraApertura,
                    it.funcionamientoHoraCierre

                  ))
                }
        return listmjutable
    }
}