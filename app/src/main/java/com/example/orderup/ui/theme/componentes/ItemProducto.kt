package com.example.orderup.ui.theme.componentes


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.orderup.model.Product
import org.jetbrains.annotations.Async

@Composable
fun ProductCard(
    producto: Product,
    cantidad: Int,
    onClick: () -> Unit
) {
    Card(
        // El contenedor completo es clickeable para agregar a la orden
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = producto.imagenUrl,
                contentDescription = producto.nombre,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = producto.nombre, fontWeight = FontWeight.Bold)
                Text(text = "$${producto.precio}")
            }
            // Muestra la cantidad solo si es mayor a 0
            if (cantidad > 0) {
                Badge {
                    Text(text = cantidad.toString())
                }
            }
        }
    }
}