package com.example.esiea3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.FruitDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FruitDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruit_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.pokemon_detail_name)
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("pokemonId") ?: -1

        Singletons.FRUIT_API.getFruitDetail(id).enqueue(object : Callback<FruitDetailResponse>{
            override fun onFailure(call: Call<FruitDetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<FruitDetailResponse>, response: Response<FruitDetailResponse>) {

                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.name
                }

            }

        })
    }
}