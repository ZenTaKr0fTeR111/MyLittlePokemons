package com.example.mylittlepokemons

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

        binding.pokemonList.adapter = PokemonAdapter(listOfPokemons)
        binding.pokemonList.layoutManager = LinearLayoutManager(this)
    }
}