package com.tecsup.demostracion_patron_maca.presentacion.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tecsup.demostracion_patron_maca.data.model.Instructor

import com.tecsup.demostracion_patron_maca.viewmodel.InstructorViewModel


@Composable
fun InstructorListScreen(viewModel: InstructorViewModel) {
    val instructorsState by viewModel.instructors.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Lista de Instructores",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(instructorsState) { instructor ->
                    // Pasamos el instructor y la acción de eliminar
                    InstructorRow(
                        instructor = instructor,
                        onDeleteClick = { viewModel.deleteInstructor(instructor) }
                    )
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}



// Fila de cada instructor, MODIFICADA para incluir el botón de Eliminar
@Composable
fun InstructorRow(instructor: Instructor, onDeleteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically // Centra el botón y el texto verticalmente
    ) {
        // Columna para mostrar los datos del instructor
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "${instructor.apellido.uppercase()}, ${instructor.nombre}",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Horas dictadas: ${instructor.horasDictadas}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Pago por hora: S/. ${instructor.pagoPorHora}",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        // Botón Eliminar
        Button(
            onClick = onDeleteClick,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Eliminar")
        }
    }
}