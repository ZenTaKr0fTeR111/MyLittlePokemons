package com.example.mylittlepokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.data.listOfPokemons
import com.example.mylittlepokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pokemonList.let {
            it.adapter = PokemonAdapter(listOfPokemons) { position ->
                val intent = Intent(this, DetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(Pokemon.POKEMON_ID_KEY, position)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            it.layoutManager = LinearLayoutManager(this)
            it.addItemDecoration(
                DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
            )
        }
    }
}