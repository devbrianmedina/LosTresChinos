package com.itess701.lostreschinos.models

import java.io.Serializable

data class Product(
    val image: Int, // Recurso de la imagen del producto (R.drawable...)
    val title: String,
    val code: String,
    val price: Double,
    val description: String,
    val characteristics: List<Pair<String, String>>,
) : Serializable