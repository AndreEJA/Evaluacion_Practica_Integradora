package ni.edu.uam.pasteleria_app.ui.screens.pedidos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ni.edu.uam.pasteleria_app.data.model.Pedido
import ni.edu.uam.pasteleria_app.ui.screens.components.PedidoCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PedidoListScreen(
    pedidos: List<Pedido> = emptyList(),
    onAgregarClick: () -> Unit,
    onEditarClick: (Long) -> Unit,
    onEliminarClick: (Long) -> Unit = {},
    onDetalleClick: (Pedido) -> Unit = {},
    onBackClick: () -> Unit
) {
    val fondoCrema = Color(0xFFFFF7EC)
    val rosaPastel = Color(0xFFF8BBD0)
    val cafeSuave = Color(0xFF6D4C41)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pedidos",
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
                actions = {
                    IconButton(onClick = onAgregarClick) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar pedido",
                            tint = cafeSuave
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = rosaPastel
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAgregarClick,
                containerColor = rosaPastel,
                contentColor = cafeSuave
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar pedido"
                )
            }
        },
        containerColor = fondoCrema
    ) { paddingValues ->

        if (pedidos.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Sin pedidos",
                            tint = rosaPastel
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "No hay pedidos registrados",
                            color = cafeSuave,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Agrega tu primer pedido para comenzar.",
                            color = Color(0xFF8D6E63)
                        )

                        Spacer(modifier = Modifier.height(18.dp))

                        Button(
                            onClick = onAgregarClick,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = rosaPastel,
                                contentColor = cafeSuave
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Agregar Pedido")
                        }
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(pedidos) { pedido ->
                    PedidoCard(
                        pedido = pedido,
                        onDetalleClick = {
                            onDetalleClick(pedido)
                        },
                        onEditarClick = {
                            pedido.id?.let { onEditarClick(it) }
                        },
                        onEliminarClick = {
                            pedido.id?.let { onEliminarClick(it) }
                        }
                    )
                }
            }
        }
    }
}