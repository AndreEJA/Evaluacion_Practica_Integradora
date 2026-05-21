package ni.edu.uam.pasteleria_app.ui.screens.pedidos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ni.edu.uam.pasteleria_app.data.model.Cliente
import ni.edu.uam.pasteleria_app.data.model.Pedido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoFormScreen(
    pedidoId: Long? = null,
    clientes: List<Cliente> = emptyList(),
    onGuardarClick: (Pedido) -> Unit,
    onBackClick: () -> Unit
) {
    val fondoCrema = Color(0xFFFFF7EC)
    val rosaPastel = Color(0xFFF8BBD0)
    val cafeSuave = Color(0xFF6D4C41)
    val blanco = Color.White

    var fechaPedido by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var clienteId by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (pedidoId == null) "Nuevo Pedido" else "Editar Pedido",
                        color = cafeSuave,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = cafeSuave
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = rosaPastel
                )
            )
        },
        containerColor = fondoCrema
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = blanco
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Pedido",
                        tint = rosaPastel
                    )

                    Text(
                        text = "Información del Pedido",
                        color = cafeSuave,
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedTextField(
                        value = fechaPedido,
                        onValueChange = { fechaPedido = it },
                        label = { Text("Fecha del pedido") },
                        placeholder = { Text("Ejemplo: 2026-05-21") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    OutlinedTextField(
                        value = descripcion,
                        onValueChange = { descripcion = it },
                        label = { Text("Descripción") },
                        placeholder = { Text("Ejemplo: Pastel de chocolate") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    OutlinedTextField(
                        value = total,
                        onValueChange = { total = it },
                        label = { Text("Total") },
                        placeholder = { Text("Ejemplo: 850") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    OutlinedTextField(
                        value = estado,
                        onValueChange = { estado = it },
                        label = { Text("Estado") },
                        placeholder = { Text("Ejemplo: Pendiente") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    OutlinedTextField(
                        value = clienteId,
                        onValueChange = { clienteId = it },
                        label = { Text("ID del cliente") },
                        placeholder = { Text("Ejemplo: 1") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            val clienteSeleccionado = clientes.find {
                                it.id == clienteId.toLongOrNull()
                            } ?: Cliente(
                                id = clienteId.toLongOrNull(),
                                nombre = "",
                                telefono = "",
                                correo = "",
                                direccion = ""
                            )

                            val pedido = Pedido(
                                id = pedidoId,
                                fechaPedido = fechaPedido,
                                descripcion = descripcion,
                                total = total.toDoubleOrNull() ?: 0.0,
                                estado = estado,
                                cliente = clienteSeleccionado
                            )

                            onGuardarClick(pedido)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = rosaPastel,
                            contentColor = cafeSuave
                        )
                    ) {
                        Text(
                            text = if (pedidoId == null) "Guardar Pedido" else "Actualizar Pedido",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}