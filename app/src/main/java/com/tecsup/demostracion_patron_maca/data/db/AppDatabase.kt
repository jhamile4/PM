package com.tecsup.demostracion_patron_maca.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tecsup.demostracion_patron_maca.data.dao.InstructorDao
import com.tecsup.demostracion_patron_maca.data.model.Instructor

@Database(entities = [Instructor::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun instructorDao(): InstructorDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "semanacrud_basico.db"
            )
                .fallbackToDestructiveMigration() // Solo para desarrollo
                .build()
    }
}