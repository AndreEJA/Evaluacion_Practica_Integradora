package ni.edu.uam.pasteleria_app.data.repository

import ni.edu.uam.pasteleria_app.data.model.Cliente
import ni.edu.uam.pasteleria_app.data.remote.ApiService

class ClienteRepository(
    private val apiService: ApiService
) {

    // Obtener todos los clientes
    suspend fun obtenerClientes(): List<Cliente> {
        return apiService.getClientes()
    }

    // Obtener cliente por ID
    suspend fun obtenerClientePorId(id: Long): Cliente {
        return apiService.getClienteById(id)
    }

    // Crear cliente
    suspend fun crearCliente(cliente: Cliente): Cliente {
        return apiService.crearCliente(cliente)
    }

    // Actualizar cliente
    suspend fun actualizarCliente(id: Long, cliente: Cliente): Cliente {
        return apiService.actualizarCliente(id, cliente)
    }

    // Eliminar cliente
    suspend fun eliminarCliente(id: Long) {
        apiService.eliminarCliente(id)
    }
}