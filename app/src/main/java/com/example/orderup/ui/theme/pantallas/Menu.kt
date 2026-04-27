package com.example.orderup.ui.theme.pantallas

import com.example.orderup.vistas.VistaOrdenes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.orderup.model.menu
import com.example.orderup.ui.theme.componentes.ProductCard
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPantalla(
    viewModel: VistaOrdenes,
    onNavigateToOrder: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú OrderUp!") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToOrder,
                icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Ver Orden") },
                text = { Text("Orden (${viewModel.getTotalItems()})") }
            )
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(menu) { producto ->
                val cantidadActual = viewModel.orderItems[producto] ?: 0
                ProductCard(
                    producto = producto,
                    cantidad = cantidadActual,
                    onClick = { viewModel.addProduct(producto) }
                )
            }
        }
    }
}