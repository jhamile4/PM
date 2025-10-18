package com.tecsup.demostracion_patron_maca.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instructor")
data class Instructor(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val apellido: String,
    val nombre: String,
    val horasDictadas: Int,
    val pagoPorHora: Double
)