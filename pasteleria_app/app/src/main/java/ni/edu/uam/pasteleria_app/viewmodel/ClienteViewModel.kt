package ni.edu.uam.pasteleria_app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ni.edu.uam.pasteleria_app.data.model.Cliente
import ni.edu.uam.pasteleria_app.data.remote.RetrofitClient
import ni.edu.uam.pasteleria_app.data.repository.ClienteRepository

class ClienteViewModel : ViewModel() {

    private val repository = ClienteRepository(RetrofitClient.apiService)

    var clientes by mutableStateOf<List<Cliente>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        cargarClientes()
    }

    fun cargarClientes() {
        viewModelScope.launch {
            try {
                isLoading = true
                error = null
                clientes = repository.obtenerClientes()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun guardarCliente(cliente: Cliente) {
        viewModelScope.launch {
            try {
                isLoading = true
                if (cliente.id == null) {
                    repository.crearCliente(cliente)
                } else {
                    repository.actualizarCliente(cliente.id, cliente)
                }
                cargarClientes()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun eliminarCliente(id: Long) {
        viewModelScope.launch {
            try {
                isLoading = true
                repository.eliminarCliente(id)
                cargarClientes()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun buscarClientePorId(id: Long?): Cliente? {
        return clientes.find { it.id == id }
    }
}