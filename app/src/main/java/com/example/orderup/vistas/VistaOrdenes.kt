package com.example.orderup.vistas

// viewmodel/OrderViewModel.kt


import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.example.orderup.model.Product

class VistaOrdenes : ViewModel() {
    private val _orderItems = mutableStateMapOf<Product, Int>()
    val orderItems: Map<Product, Int> get() = _orderItems

    fun addProduct(producto: Product) {
        val currentCount = _orderItems[producto] ?: 0
        _orderItems[producto] = currentCount + 1
    }

    fun removeProduct(producto: Product) {
        _orderItems.remove(producto)
    }

    fun clearOrder() {
        _orderItems.clear()
    }

    fun getTotalItems(): Int {
        return _orderItems.values.sum()
    }

    fun getTotalPrice(): Double {
        return _orderItems.entries.sumOf { it.key.precio * it.value }
    }
}