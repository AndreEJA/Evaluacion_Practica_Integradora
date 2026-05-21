package ni.edu.uam.pasteleria_app.ui.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LoadingIndicator(
    mensaje: String = "Cargando..."
) {

    val rosaPastel = Color(0xFFF8BBD0)
    val cafeSuave = Color(0xFF6D4C41)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(
            modifier = Modifier.size(60.dp),
            color = rosaPastel,
            strokeWidth = 5.dp
        )

        Text(
            text = mensaje,
            color = cafeSuave,
            fontWeight = FontWeight.Bold
        )
    }
}