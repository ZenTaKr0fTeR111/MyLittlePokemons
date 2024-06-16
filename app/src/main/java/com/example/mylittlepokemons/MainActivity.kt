package com.example.mylittlepokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylittlepokemons.data.listOfPokemons
import com.example.mylittlepokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pokemonList.adapter = PokemonAdapter(listOfPokemons) { position ->
            val intent = Intent(this, DetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("pokemon_id", position)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.pokemonList.layoutManager = LinearLayoutManager(this)
    }
}