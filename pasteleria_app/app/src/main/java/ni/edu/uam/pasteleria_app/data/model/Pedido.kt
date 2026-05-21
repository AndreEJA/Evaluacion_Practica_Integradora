package ni.edu.uam.pasteleria_app.data.model

data class Pedido(
    val id: Long? = null,
    val fechaPedido: String,
    val descripcion: String,
    val total: Double,
    val estado: String,
    val cliente: Cliente
)