package com.example.mylittlepokemons.data

import androidx.annotation.DrawableRes
import com.example.mylittlepokemons.R

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    @DrawableRes val spriteRes: Int,
    val stats: HashMap<String, Int>,
    val types: List<String>,
) {
    companion object {
        const val POKEMON_ID_KEY = "pokemon_id"

        const val HP_KEY = "hp"
        const val ATTACK_KEY = "attack"
        const val DEFENSE_KEY = "defense"
        const val SPEC_ATTACK_KEY = "special_attack"
        const val SPEC_DEFENSE_KEY = "special_defense"
        const val SPEED_KEY = "speed"
    }

    fun isSpecial() = types.intersect(SpecialTypes.getElements()).isNotEmpty()

    fun getSpecialImageByType() = when {
        SpecialTypes.FIRE.element in types -> SpecialTypes.FIRE.image
        SpecialTypes.WATER.element in types -> SpecialTypes.WATER.image
        SpecialTypes.GRASS.element in types -> SpecialTypes.GRASS.image
        else -> 0
    }
}

enum class SpecialTypes(val element: String, @DrawableRes val image: Int) {
    FIRE("Fire", R.drawable.fire_icon),
    WATER("Water", R.drawable.water_icon),
    GRASS("Grass", R.drawable.grass_icon);

    companion object {
        fun getElements() = entries.map { it.element }.toSet()
    }
}