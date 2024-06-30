package com.example.mylittlepokemons

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import com.example.mylittlepokemons.data.Pokemon
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

        val pokemonID = intent.getIntExtra(Pokemon.POKEMON_ID_KEY, -1)
        val pokemon = listOfPokemons[pokemonID]

        with(binding) {
            pokemon?.let {
                setupSpecs(it)
                setupStats(it)
                setupSpecial(it)
            } ?: run {
                weight.isVisible = false
                height.isVisible = false
                Snackbar.make(
                    root, "No pokemon with such id exists", Snackbar.LENGTH_INDEFINITE
                ).apply {
                    setAction("Ok") {
                        dismiss()
                        finish()
                    }
                    show()
                }
            }
        }
    }

    private fun setupSpecs(p: Pokemon) = binding.apply {
        val pokName = p.name
        pokemonName.text = SpannableString(pokName).also {
            it.setSpan(
                UnderlineSpan(),
                0,
                pokName.length,
                0
            )
        }
        heightValue.text = p.height.toString()
        weightValue.text = p.weight.toString()
        pokemonImage.setImageResource(p.spriteRes)
        typesValues.text = p.types.joinToString()
    }

    private fun setupStats(p: Pokemon) = binding.apply {
        hpValue.text = p.stats[Pokemon.HP_KEY].toString()
        attackValue.text = p.stats[Pokemon.ATTACK_KEY].toString()
        defenseValue.text = p.stats[Pokemon.DEFENSE_KEY].toString()
        specialAttackValue.text = p.stats[Pokemon.SPEC_ATTACK_KEY].toString()
        specialDefenseValue.text = p.stats[Pokemon.SPEC_DEFENSE_KEY].toString()
        speedValue.text = p.stats[Pokemon.SPEED_KEY].toString()
    }

    private fun setupSpecial(p: Pokemon) = binding.apply {
        if (p.isSpecial()) {
            specialImage?.isVisible = true
            specialImage?.setImageResource(p.getSpecialImageByType())
            root.background =
                AppCompatResources.getDrawable(this@DetailsActivity, R.color.special_item)
        } else {
            specialImage?.isVisible = false
            root.background =
                AppCompatResources.getDrawable(this@DetailsActivity, R.color.regular_item)
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