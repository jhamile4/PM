package com.tecsup.demostracion_patron_maca.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.demostracion_patron_maca.data.db.AppDatabase
import com.tecsup.demostracion_patron_maca.data.model.Instructor
import com.tecsup.demostracion_patron_maca.repository.InstructorRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class InstructorViewModel(application: Application): AndroidViewModel(application) {
    private val repository: InstructorRepository
    val instructors: StateFlow<List<Instructor>>

    init {
        val dao = AppDatabase.getInstance(application).instructorDao()
        repository= InstructorRepository(dao)

        instructors = repository.getAll()
            .map { it }
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    }

    fun insertInstructor(apellido: String, nombre: String, horas: Int, pagoHora: Double){
        val inst= Instructor(
            apellido=apellido,
            nombre = nombre,
            horasDictadas = horas,
            pagoPorHora = pagoHora
        )

        viewModelScope.launch {
            repository.insert(inst)
        }
    }
    fun deleteInstructor(instructor: Instructor) {
        viewModelScope.launch {
            repository.delete(instructor)
        }
    }
}
