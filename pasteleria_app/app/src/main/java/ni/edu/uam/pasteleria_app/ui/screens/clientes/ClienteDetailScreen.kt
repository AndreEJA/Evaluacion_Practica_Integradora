package ni.edu.uam.pasteleria_app.ui.screens.clientes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ni.edu.uam.pasteleria_app.data.model.Cliente

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClienteDetailScreen(
    cliente: Cliente,
    onBackClick: () -> Unit,
    onEditarClick: (Long) -> Unit,
    onEliminarClick: (Long) -> Unit
) {
    val fondoCrema = Color(0xFFFFF7EC)
    val rosaPastel = Color(0xFFF8BBD0)
    val cafeSuave = Color(0xFF6D4C41)
    val blanco = Color(0xFFFFFFFF)
    val rojoSuave = Color(0xFFE57373)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle del Cliente",
                        color = cafeSuave,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            contentAlignment = Alignment.TopCenter
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Cliente",
                        tint = rosaPastel,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    Text(
                        text = cliente.nombre,
                        color = cafeSuave,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    ClienteInfoItem(
                        icon = Icons.Default.Phone,
                        titulo = "Teléfono",
                        valor = cliente.telefono,
                        colorTexto = cafeSuave
                    )

                    ClienteInfoItem(
                        icon = Icons.Default.Email,
                        titulo = "Correo",
                        valor = cliente.correo,
                        colorTexto = cafeSuave
                    )

                    ClienteInfoItem(
                        icon = Icons.Default.Home,
                        titulo = "Dirección",
                        valor = cliente.direccion,
                        colorTexto = cafeSuave
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {
                                cliente.id?.let { onEditarClick(it) }
                            },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = rosaPastel,
                                contentColor = cafeSuave
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Editar"
                            )
                            Text(
                                text = "Editar",
                                modifier = Modifier.padding(start = 6.dp)
                            )
                        }

                        OutlinedButton(
                            onClick = {
                                cliente.id?.let { onEliminarClick(it) }
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = rojoSuave
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Eliminar"
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
    }
}

@Composable
fun ClienteInfoItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    titulo: String,
    valor: String,
    colorTexto: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(
                color = Color(0xFFFFF1F5),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = titulo,
            tint = Color(0xFFD81B60)
        )

        Column(
            modifier = Modifier.padding(start = 14.dp)
        ) {
            Text(
                text = titulo,
                color = colorTexto,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = valor,
                color = Color(0xFF8D6E63)
            )
        }
    }
}