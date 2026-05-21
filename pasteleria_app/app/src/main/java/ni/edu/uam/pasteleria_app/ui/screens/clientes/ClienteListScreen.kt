package ni.edu.uam.pasteleria_app.ui.screens.clientes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ni.edu.uam.pasteleria_app.data.model.Cliente

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteListScreen(
    clientes: List<Cliente> = emptyList(),
    onAgregarClick: () -> Unit,
    onEditarClick: (Long) -> Unit,
    onEliminarClick: (Long) -> Unit = {},
    onDetalleClick: (Cliente) -> Unit = {},
    onBackClick: () -> Unit
) {
    val fondoCrema = Color(0xFFFFF7EC)
    val rosaPastel = Color(0xFFF8BBD0)
    val cafeSuave = Color(0xFF6D4C41)
    val rosaClaro = Color(0xFFFFF1F5)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Clientes",
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
                            contentDescription = "Agregar cliente",
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
                    contentDescription = "Agregar cliente"
                )
            }
        },
        containerColor = fondoCrema
    ) { paddingValues ->

        if (clientes.isEmpty()) {
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
                            imageVector = Icons.Default.Person,
                            contentDescription = "Sin clientes",
                            tint = rosaPastel,
                            modifier = Modifier.size(55.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "No hay clientes registrados",
                            color = cafeSuave,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Agrega tu primer cliente para comenzar.",
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
                            Text("Agregar Cliente")
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
                items(clientes) { cliente ->
                    ClienteCardItem(
                        cliente = cliente,
                        rosaClaro = rosaClaro,
                        rosaPastel = rosaPastel,
                        cafeSuave = cafeSuave,
                        onDetalleClick = {
                            onDetalleClick(cliente)
                        },
                        onEditarClick = {
                            cliente.id?.let { onEditarClick(it) }
                        },
                        onEliminarClick = {
                            cliente.id?.let { onEliminarClick(it) }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ClienteCardItem(
    cliente: Cliente,
    rosaClaro: Color,
    rosaPastel: Color,
    cafeSuave: Color,
    onDetalleClick: () -> Unit,
    onEditarClick: () -> Unit,
    onEliminarClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onDetalleClick() },
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = rosaClaro,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Cliente",
                        tint = Color(0xFFD81B60)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = cliente.nombre,
                        color = cafeSuave,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = cliente.direccion,
                        color = Color(0xFF8D6E63)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = rosaClaro,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Teléfono",
                    tint = cafeSuave,
                    modifier = Modifier.size(18.dp)
                )

                Text(
                    text = cliente.telefono,
                    color = cafeSuave,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = rosaClaro,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Correo",
                    tint = cafeSuave,
                    modifier = Modifier.size(18.dp)
                )

                Text(
                    text = cliente.correo,
                    color = cafeSuave,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Button(
                    onClick = onEditarClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = rosaPastel,
                        contentColor = cafeSuave
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar",
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "Editar",
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }

                OutlinedButton(
                    onClick = onEliminarClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFFE57373)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "Eliminar",
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
            }
        }
    }
}