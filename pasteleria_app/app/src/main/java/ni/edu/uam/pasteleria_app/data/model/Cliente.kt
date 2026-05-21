package ni.edu.uam.pasteleria_app.data.model

data class Cliente(
    val id: Long? = null,
    val nombre: String,
    val telefono: String,
    val correo: String,
    val direccion: String
)
