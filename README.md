# Evaluacion_Practica_Integradora
🍰 Pastelería App

Aplicación móvil desarrollada en Kotlin utilizando Android Studio y Jetpack Compose para la gestión de clientes y pedidos de una pastelería.
La aplicación consume una API REST desarrollada con Spring Boot y permite realizar operaciones CRUD completas.

📱 Características
Gestión de Clientes
Registrar clientes.
Visualizar clientes.
Editar clientes.
Eliminar clientes.
Ver detalles de clientes.
Gestión de Pedidos
Registrar pedidos.
Visualizar pedidos.
Editar pedidos.
Eliminar pedidos.
Ver detalles de pedidos.
Navegación
Navegación entre múltiples pantallas.
Pantalla principal.
Pantallas de detalle y formularios.
Manejo de Estado
Actualización dinámica de información.
Persistencia temporal durante ejecución.
Consumo de datos desde API REST.
Diseño UI/UX
Interfaz moderna inspirada en temática de pastelería.
Uso de colores pastel.
Diseño limpio y organizado.
🛠 Tecnologías Utilizadas
Frontend
Kotlin
Android Studio
Jetpack Compose
Material Design 3
Navigation Compose
ViewModel
Backend
Spring Boot
Java
API REST
Consumo de API
Retrofit
Gson Converter
Kotlin Coroutines
Base de Datos
MySQL
Control de Versiones
Git
GitHub
📂 Estructura del Proyecto
app/
└── src/main/java/ni/edu/uam/pasteleria_app/
    ├── data/
    │   ├── model/
    │   ├── remote/
    │   └── repository/
    │
    ├── ui/
    │   ├── components/
    │   ├── navigation/
    │   └── screens/
    │
    └── viewmodel/
🔌 Configuración de la API
Emulador Android
private const val BASE_URL = "http://10.0.2.2:8080/"
Dispositivo físico
private const val BASE_URL = "http://TU_IP_LOCAL:8080/"

Ejemplo:

private const val BASE_URL = "http://192.168.1.10:8080/"
⚙️ Configuración Importante
Permiso de Internet

Agregar en AndroidManifest.xml:

<uses-permission android:name="android.permission.INTERNET"/>
Permitir tráfico HTTP

Dentro de <application>:

android:usesCleartextTraffic="true"
android:networkSecurityConfig="@xml/network_security_config"
Archivo network_security_config.xml

Ruta:

res/xml/network_security_config.xml

Contenido:

<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <base-config cleartextTrafficPermitted="true" />
</network-security-config>
▶️ Ejecución del Proyecto
Clonar el repositorio:
git clone https://github.com/usuario/repositorio.git
Abrir el proyecto en Android Studio.
Ejecutar la API Spring Boot.
Configurar la IP en RetrofitClient.kt.
Ejecutar la aplicación.
👥 Integrantes
Andre Joiner
[Agregar integrantes del equipo]
📌 Estado del Proyecto

✅ En desarrollo funcional
✅ CRUD implementado
✅ Navegación implementada
✅ Conexión con API REST
✅ Diseño UI personalizado
