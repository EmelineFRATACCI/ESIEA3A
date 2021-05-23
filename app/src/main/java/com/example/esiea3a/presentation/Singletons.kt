package com.example.esiea3a.presentation

import com.example.esiea3a.presentation.FruitApplication.Companion.context
import com.example.esiea3a.presentation.api.FruitApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object{


        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)  // 10 MiB
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val FRUIT_API: FruitApi = Retrofit.Builder()
            .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FruitApi::class.java)


    }
}
