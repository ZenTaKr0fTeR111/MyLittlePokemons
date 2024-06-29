package com.example.mylittlepokemons

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.MenuItem
import android.view.View
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
                val pokName = it.name
                pokemonName.text = SpannableString(pokName).also {
                    it.setSpan(
                        UnderlineSpan(),
                        0,
                        pokName.length,
                        0
                    )
                }
                heightValue.text = it.height.toString()
                weightValue.text = it.weight.toString()
                pokemonImage.setImageResource(it.spriteRes)
                typesValues.text = it.types.joinToString()

                hpValue.text = it.stats[Pokemon.HP_KEY].toString()
                attackValue.text = it.stats[Pokemon.ATTACK_KEY].toString()
                defenseValue.text = it.stats[Pokemon.DEFENSE_KEY].toString()
                specialAttackValue.text = it.stats[Pokemon.SPEC_ATTACK_KEY].toString()
                specialDefenseValue.text = it.stats[Pokemon.SPEC_DEFENSE_KEY].toString()
                speedValue.text = it.stats[Pokemon.SPEED_KEY].toString()

                if (it.isSpecial()) {
                    specialImage?.visibility = View.VISIBLE
                    specialImage?.setImageResource(it.getSpecialImageByType())
                    root.background =
                        AppCompatResources.getDrawable(this@DetailsActivity, R.color.special_item)
                }
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