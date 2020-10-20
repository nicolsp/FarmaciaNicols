package com.example.farmacianicols.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.farmacianicols.FarmaciasRepository
import com.example.farmacianicols.local.FarmaciasDatBaseee
import com.example.farmacianicols.local.FarmaciasUsadas
import kotlinx.coroutines.launch

class FarmaciasViewModel (application: Application): AndroidViewModel(application){

    private lateinit var repository: FarmaciasRepository

    init {
        val farmaciasDao = FarmaciasDatBaseee

    }

    fun exposeLiveDataFromDataBase() : LiveData<List<FarmaciasUsadas>> {
        return repository.mLiveData
    }

    fun obtainFarmaciasByID(id : Int): LiveData<FarmaciasUsadas> {
        return repository.obtainFarmaciasByID(id)
    }

fun updateFarmacias(farmaciasUsadas: FarmaciasUsadas) = viewModelScope.launch {
    repository.updateFarmacias(farmaciasUsadas)
}

}