# 📚 Gestión de Instructores - App Móvil

Este es un **proyecto prototipo** de una aplicación móvil Android desarrollada para el **Instituto Tecnológico TECSUP** con el fin de **gestionar a sus instructores**.  
El objetivo principal es demostrar la implementación de **operaciones CRUD** (Crear, Leer, Actualizar y Eliminar) utilizando las **tecnologías de arquitectura moderna de Android**.

---

## ✨ Características Principales

- 🧑‍🏫 **Registro de Instructores:**  
  Formulario para ingresar nuevos instructores con sus datos (Apellido, Nombre, Horas Dictadas, Pago por Hora).  

- 📋 **Listado Reactivo:**  
  Muestra la lista completa de instructores guardados en la base de datos local, actualizándose en tiempo real.  

- 💾 **Persistencia Local:**  
  Almacenamiento de datos mediante una base de datos **Room**.  

- ❌ **Eliminación de Registros:**  
  Permite eliminar instructores directamente desde la lista para completar el ciclo CRUD.  

---

## 🛠️ Tecnologías Utilizadas

Este proyecto sigue el patrón de arquitectura **MVVM (Model-View-ViewModel)** y está construido completamente con el **stack moderno de Android**:

| 🧩 Componente | 💡 Tecnología | 🎯 Propósito |
|---------------|---------------|--------------|
| Arquitectura | **MVVM** | Separación de la lógica de negocio, datos y UI |
| UI (Vista) | **Jetpack Compose** | Declaración de la interfaz de usuario |
| Persistencia | **Room Database** | Base de datos local SQLite ORM para la tabla `Instructor` |
| Asincronía | **Kotlin Coroutines** | Gestión eficiente de operaciones I/O sin bloquear el hilo principal |
| Flujo de Datos | **StateFlow / Flow** | Provee un flujo de datos reactivo desde la capa de datos hasta la UI |
| Dependencias | **ViewModel** | Mantiene la lógica del negocio y expone el estado de la UI |


com.leon.semanacrud_basico/
├── data/
│ ├── dao/ # Interfaces de acceso a datos (InstructorDao)
│ ├── db/ # Implementación de la base de datos (AppDatabase)
│ └── model/ # Entidades Room (@Entity Instructor)
├── presentation/
│ ├── screens/ # Componentes Compose (Formulario y Lista)
│ └── MainActivity.kt # Punto de entrada de la aplicación
├── repository/ # Lógica para manejar y abstraer el acceso a datos
├── viewmodel/ # Lógica del estado de la UI (InstructorViewModel)


---

## 🚀 Instalación y Ejecución

Sigue estos pasos para ejecutar el proyecto en tu máquina local:

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/jhamile4/PM.git

2️⃣ Abrir en Android Studio

Abre Android Studio y selecciona File > Open.

Navega a la carpeta PM y ábrela.

3️⃣ Sincronizar Gradle

Espera a que Gradle sincronice las dependencias (Room, Compose, Coroutines).

4️⃣ Ejecutar

Selecciona un emulador o dispositivo físico.

Presiona el botón Run ▶️.

👨‍💻 Autor

Desarrollador: [jhamile macavilca]

Curso: Programación Móvil con Kotlin y Jetpack Compose

Docente: Juan José León
---

## 🏗️ Estructura del Proyecto

