package com.example.esiea3a.presentation.api

import com.example.esiea3a.presentation.list.Fruit

data class FruitListResponse(
    val id: Int,
    val title: String,
    val extendedIngredients: List<Fruit>
)