package com.example.farmacianicols.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.farmacianicols.FarmaciasRepository
import com.example.farmacianicols.local.FarmaciasDatBaseee
import com.example.farmacianicols.local.FarmaciasUsadas
import kotlinx.coroutines.launch

abstract class FarmaciasViewModel (application: Application): AndroidViewModel(application){

    abstract val mRepository : FarmaciasRepository
    //val liveDataFromLocal : LiveData<List<FarmaciasUsadas>>
    abstract val liveDataFromLocal : LiveData<List<FarmaciasUsadas>>

   init {
       val farmaDao = FarmaciasDatBaseee.get
   }
   //init {
     //  val farmaciasDao = FarmaciasDatBaseee.getDataBase(application)
       // mRepository = FarmaciasRepository(farmaciasDao)
       // mRepository.getDataFromServe()
    //}

    fun exposeLiveDataFromDataBase() : LiveData<List<FarmaciasUsadas>> {
        return mRepository.mLiveData
    }

    fun obtainFarmaciasByID(id : Int): LiveData<FarmaciasUsadas> {
        return mRepository.obtainFarmaciasByID(id)
    }

fun updateFarmacias(farmaciasUsadas: FarmaciasUsadas) = viewModelScope.launch {
    mRepository.obtainFarmaciasByID(id )
}

}