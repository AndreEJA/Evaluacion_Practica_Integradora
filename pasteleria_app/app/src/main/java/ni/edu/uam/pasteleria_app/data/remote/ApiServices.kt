package ni.edu.uam.pasteleria_app.data.remote

import ni.edu.uam.pasteleria_app.data.model.Cliente
import ni.edu.uam.pasteleria_app.data.model.Pedido
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    // =========================
    // CLIENTES
    // =========================

    @GET("api/clientes")
    suspend fun getClientes(): List<Cliente>

    @GET("api/clientes/{id}")
    suspend fun getClienteById(
        @Path("id") id: Long
    ): Cliente

    @POST("api/clientes")
    suspend fun crearCliente(
        @Body cliente: Cliente
    ): Cliente

    @PUT("api/clientes/{id}")
    suspend fun actualizarCliente(
        @Path("id") id: Long,
        @Body cliente: Cliente
    ): Cliente

    @DELETE("api/clientes/{id}")
    suspend fun eliminarCliente(
        @Path("id") id: Long
    )



    // =========================
    // PEDIDOS
    // =========================

    @GET("api/pedidos")
    suspend fun getPedidos(): List<Pedido>

    @GET("api/pedidos/{id}")
    suspend fun getPedidoById(
        @Path("id") id: Long
    ): Pedido

    @POST("api/pedidos")
    suspend fun crearPedido(
        @Body pedido: Pedido
    ): Pedido

    @PUT("api/pedidos/{id}")
    suspend fun actualizarPedido(
        @Path("id") id: Long,
        @Body pedido: Pedido
    ): Pedido

    @DELETE("api/pedidos/{id}")
    suspend fun eliminarPedido(
        @Path("id") id: Long
    )
}