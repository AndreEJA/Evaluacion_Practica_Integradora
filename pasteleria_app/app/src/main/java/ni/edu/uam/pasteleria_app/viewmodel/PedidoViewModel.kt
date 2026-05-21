package ni.edu.uam.pasteleria_app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ni.edu.uam.pasteleria_app.data.model.Pedido
import ni.edu.uam.pasteleria_app.data.remote.RetrofitClient
import ni.edu.uam.pasteleria_app.data.repository.PedidoRepository

class PedidoViewModel : ViewModel() {

    private val repository = PedidoRepository(RetrofitClient.apiService)

    var pedidos by mutableStateOf<List<Pedido>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        cargarPedidos()
    }

    fun cargarPedidos() {
        viewModelScope.launch {
            try {
                isLoading = true
                error = null
                pedidos = repository.obtenerPedidos()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun guardarPedido(pedido: Pedido) {
        viewModelScope.launch {
            try {
                isLoading = true
                if (pedido.id == null) {
                    repository.crearPedido(pedido)
                } else {
                    repository.actualizarPedido(pedido.id, pedido)
                }
                cargarPedidos()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun eliminarPedido(id: Long) {
        viewModelScope.launch {
            try {
                isLoading = true
                repository.eliminarPedido(id)
                cargarPedidos()
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }

    fun buscarPedidoPorId(id: Long?): Pedido? {
        return pedidos.find { it.id == id }
    }
}