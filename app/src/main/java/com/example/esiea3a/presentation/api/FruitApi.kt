package com.example.esiea3a.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//DOC
//https://spoonacular.com/food-api/docs#Get-Recipe-Information

interface FruitApi {
    @GET("recipes/{id}/information")
    fun getFruitList(): Call<FruitListResponse>

    @GET("recipes/{id}/information")
    fun getFruitDetail(@Path("id") id: Int): Call<FruitDetailResponse>
}