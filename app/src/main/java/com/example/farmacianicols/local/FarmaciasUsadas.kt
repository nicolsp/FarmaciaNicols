package com.example.farmacianicols.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmacias_table")

class FarmaciasUsadas (@PrimaryKey @NonNull  val id: Int,
                       val comunaNombre: String,
                       val fecha: String,
                       val fkComuna: String,
                       val fkLocalidad: String,
                       val fkRegion: String,
                       val fkFuncionamiento: String,
                       val LocalDirecion: String,
                       val FuncionamientoHoraApertura: String,
                       val FuncionamientoHoraCierre:String
)