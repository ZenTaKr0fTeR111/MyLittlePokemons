package com.example.mylittlepokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.data.getPokemonsAsList
import com.example.mylittlepokemons.databinding.ActivityMainBinding
import com.example.mylittlepokemons.recycler.PokemonAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonAdapter = PokemonAdapter { id ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(Pokemon.POKEMON_ID_KEY, id)
            startActivity(intent)
        }
        binding.pokemonList.adapter = pokemonAdapter
        binding.pokemonList.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL).apply {
                AppCompatResources.getDrawable(this@MainActivity, R.drawable.divider)?.let {
                    setDrawable(it)
                }
            }
        )
        pokemonAdapter.submitItems(getPokemonsAsList())
    }
}
