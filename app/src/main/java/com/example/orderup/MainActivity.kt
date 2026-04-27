package com.example.orderup


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orderup.ui.theme.pantallas.MenuPantalla
import com.example.orderup.ui.theme.pantallas.OrdenPantalla
import com.example.orderup.ui.theme.OrderUpTheme
import com.example.orderup.vistas.VistaOrdenes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderUpTheme {
                OrderUpApp()
            }
        }
    }
}

@Composable
fun OrderUpApp() {
    val navController = rememberNavController()
    // El ViewModel se instancia aquí para compartir el estado entre pantallas
    val orderViewModel: VistaOrdenes = viewModel()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuPantalla(
                viewModel = orderViewModel,
                onNavigateToOrder = { navController.navigate("order") }
            )
        }
        composable("order") {
            OrdenPantalla(
                viewModel = orderViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}