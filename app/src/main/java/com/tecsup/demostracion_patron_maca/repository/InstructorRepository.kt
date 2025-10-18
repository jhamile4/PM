package com.tecsup.demostracion_patron_maca.repository



import com.tecsup.demostracion_patron_maca.data.dao.InstructorDao
import com.tecsup.demostracion_patron_maca.data.model.Instructor
import kotlinx.coroutines.flow.Flow

class InstructorRepository(private val dao: InstructorDao) {

    suspend fun insert(instructor: Instructor): Long {
        return dao.insert(instructor)
    }

    fun getAll(): Flow<List<Instructor>> = dao.getAllInstructors()

    // Función para ELIMINAR (Nuevo)
    suspend fun delete(instructor: Instructor) {
        dao.delete(instructor)
    }
}