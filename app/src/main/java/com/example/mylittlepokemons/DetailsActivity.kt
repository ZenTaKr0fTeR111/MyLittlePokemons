package com.example.mylittlepokemons

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mylittlepokemons.data.listOfPokemons
import com.example.mylittlepokemons.databinding.ActivityDetailsBinding
import com.google.android.material.snackbar.Snackbar

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val pokemon_id = intent.getIntExtra("pokemon_id", -1)
        val pokemon = listOfPokemons.find { pokemon_id == it.id }

        if (pokemon == null) {
            binding.weight.isVisible = false
            binding.height.isVisible = false
            Snackbar.make(binding.root, "No pokemon with such id exists", Snackbar.LENGTH_INDEFINITE).apply {
                setAction("Ok") {
                    dismiss()
                    finish()
                }
                show()
            }
        } else {
            binding.apply {
                pokemonName.text = pokemon.name
                heightValue.text = pokemon.height.toString()
                weightValue.text = pokemon.weight.toString()
                pokemonImage.setImageResource(pokemon.sprite)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}