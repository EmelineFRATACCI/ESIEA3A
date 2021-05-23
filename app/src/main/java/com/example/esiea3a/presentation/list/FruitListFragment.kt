package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.FruitListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FruitListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView


    private val adapter = FruitAdapter(listOf(), ::onClickedFruit)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruit_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.fruit_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@FruitListFragment.adapter
        }




        Singletons.FRUIT_API.getFruitList().enqueue(object: Callback<FruitListResponse>{

            override fun onFailure(call: Call<FruitListResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<FruitListResponse>, response: Response<FruitListResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val fruitResponse = response.body()!!
                    adapter.updateList(fruitResponse.extendedIngredients)
                }
            }

        })

    }

    private fun onClickedFruit(id: Int) {
        findNavController().navigate(R.id.navigateToFruitDetailFragment, bundleOf(
                "pokemonId" to (id + 1)
        ))
    }
}