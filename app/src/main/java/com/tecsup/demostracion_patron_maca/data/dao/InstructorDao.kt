package com.tecsup.demostracion_patron_maca.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete // Importación necesaria para eliminar
import com.tecsup.demostracion_patron_maca.data.model.Instructor


import kotlinx.coroutines.flow.Flow

@Dao
interface InstructorDao {

    @Insert
    suspend fun insert(instructor: Instructor): Long // Función para INSERTAR

    @Query("SELECT * FROM instructor ORDER BY apellido ASC")
    fun getAllInstructors(): Flow<List<Instructor>> // Función para LISTAR (Leer)

    @Delete
    suspend fun delete(instructor: Instructor) // Función para ELIMINAR (Nuevo)
}