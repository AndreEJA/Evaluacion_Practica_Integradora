package ni.edu.uam.pasteleria_app.data.repository

import ni.edu.uam.pasteleria_app.data.model.Pedido
import ni.edu.uam.pasteleria_app.data.remote.ApiService

class PedidoRepository(
    private val apiService: ApiService
) {

    // Obtener todos los pedidos
    suspend fun obtenerPedidos(): List<Pedido> {
        return apiService.getPedidos()
    }

    // Obtener pedido por ID
    suspend fun obtenerPedidoPorId(id: Long): Pedido {
        return apiService.getPedidoById(id)
    }

    // Crear pedido
    suspend fun crearPedido(pedido: Pedido): Pedido {
        return apiService.crearPedido(pedido)
    }

    // Actualizar pedido
    suspend fun actualizarPedido(id: Long, pedido: Pedido): Pedido {
        return apiService.actualizarPedido(id, pedido)
    }

    // Eliminar pedido
    suspend fun eliminarPedido(id: Long) {
        apiService.eliminarPedido(id)
    }
}