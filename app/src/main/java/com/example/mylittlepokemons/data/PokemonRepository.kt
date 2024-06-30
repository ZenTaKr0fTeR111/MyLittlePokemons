package com.example.mylittlepokemons.data

import com.example.mylittlepokemons.R

fun getPokemonsAsList() = listOfPokemons.values.toList()

val listOfPokemons = listOf(
    Pokemon(
        0, "Bulbasaur", 7, 69, R.drawable._1,
        hashMapOf(
            Pokemon.HP_KEY to 45,
            Pokemon.ATTACK_KEY to 49,
            Pokemon.DEFENSE_KEY to 49,
            Pokemon.SPEC_ATTACK_KEY to 65,
            Pokemon.SPEC_DEFENSE_KEY to 65,
            Pokemon.SPEED_KEY to 45
        ),
        listOf("Grass", "Poison")
    ),
    Pokemon(
        1, "Ivysaur", 10, 130, R.drawable._2,
        hashMapOf(
            Pokemon.HP_KEY to 60,
            Pokemon.ATTACK_KEY to 62,
            Pokemon.DEFENSE_KEY to 63,
            Pokemon.SPEC_ATTACK_KEY to 80,
            Pokemon.SPEC_DEFENSE_KEY to 80,
            Pokemon.SPEED_KEY to 60
        ),
        listOf("Grass", "Poison")
    ),
    Pokemon(
        2, "Venusaur", 20, 1000, R.drawable._3,
        hashMapOf(
            Pokemon.HP_KEY to 80,
            Pokemon.ATTACK_KEY to 82,
            Pokemon.DEFENSE_KEY to 83,
            Pokemon.SPEC_ATTACK_KEY to 100,
            Pokemon.SPEC_DEFENSE_KEY to 100,
            Pokemon.SPEED_KEY to 80
        ),
        listOf("Grass", "Poison")
    ),
    Pokemon(
        3, "Charmander", 6, 85, R.drawable._4,
        hashMapOf(
            Pokemon.HP_KEY to 39,
            Pokemon.ATTACK_KEY to 52,
            Pokemon.DEFENSE_KEY to 43,
            Pokemon.SPEC_ATTACK_KEY to 60,
            Pokemon.SPEC_DEFENSE_KEY to 50,
            Pokemon.SPEED_KEY to 65
        ),
        listOf("Fire")
    ),
    Pokemon(
        4, "Charmeleon", 11, 190, R.drawable._5,
        hashMapOf(
            Pokemon.HP_KEY to 58,
            Pokemon.ATTACK_KEY to 64,
            Pokemon.DEFENSE_KEY to 58,
            Pokemon.SPEC_ATTACK_KEY to 80,
            Pokemon.SPEC_DEFENSE_KEY to 65,
            Pokemon.SPEED_KEY to 80
        ),
        listOf("Fire")
    ),
    Pokemon(
        5, "Charizard", 17, 905, R.drawable._6,
        hashMapOf(
            Pokemon.HP_KEY to 78,
            Pokemon.ATTACK_KEY to 84,
            Pokemon.DEFENSE_KEY to 78,
            Pokemon.SPEC_ATTACK_KEY to 109,
            Pokemon.SPEC_DEFENSE_KEY to 85,
            Pokemon.SPEED_KEY to 100
        ),
        listOf("Fire", "Flying")
    ),
    Pokemon(
        6, "Squirtle", 5, 90, R.drawable._7,
        hashMapOf(
            Pokemon.HP_KEY to 44,
            Pokemon.ATTACK_KEY to 48,
            Pokemon.DEFENSE_KEY to 65,
            Pokemon.SPEC_ATTACK_KEY to 50,
            Pokemon.SPEC_DEFENSE_KEY to 64,
            Pokemon.SPEED_KEY to 43
        ),
        listOf("Water")
    ),
    Pokemon(
        7, "Wartortle", 10, 225, R.drawable._8,
        hashMapOf(
            Pokemon.HP_KEY to 59,
            Pokemon.ATTACK_KEY to 63,
            Pokemon.DEFENSE_KEY to 80,
            Pokemon.SPEC_ATTACK_KEY to 65,
            Pokemon.SPEC_DEFENSE_KEY to 80,
            Pokemon.SPEED_KEY to 58
        ),
        listOf("Water")
    ),
    Pokemon(
        8, "Blastoise", 16, 855, R.drawable._9,
        hashMapOf(
            Pokemon.HP_KEY to 79,
            Pokemon.ATTACK_KEY to 83,
            Pokemon.DEFENSE_KEY to 100,
            Pokemon.SPEC_ATTACK_KEY to 85,
            Pokemon.SPEC_DEFENSE_KEY to 105,
            Pokemon.SPEED_KEY to 78
        ),
        listOf("Water")
    ),
    Pokemon(
        9, "Caterpie", 3, 29, R.drawable._10,
        hashMapOf(
            Pokemon.HP_KEY to 45,
            Pokemon.ATTACK_KEY to 30,
            Pokemon.DEFENSE_KEY to 35,
            Pokemon.SPEC_ATTACK_KEY to 20,
            Pokemon.SPEC_DEFENSE_KEY to 20,
            Pokemon.SPEED_KEY to 45
        ),
        listOf("Bug")
    ),
    Pokemon(
        10, "Metapod", 7, 99, R.drawable._11,
        hashMapOf(
            Pokemon.HP_KEY to 50,
            Pokemon.ATTACK_KEY to 20,
            Pokemon.DEFENSE_KEY to 55,
            Pokemon.SPEC_ATTACK_KEY to 25,
            Pokemon.SPEC_DEFENSE_KEY to 25,
            Pokemon.SPEED_KEY to 30
        ),
        listOf("Bug")
    ),
    Pokemon(
        11, "Butterfree", 11, 320, R.drawable._12,
        hashMapOf(
            Pokemon.HP_KEY to 60,
            Pokemon.ATTACK_KEY to 45,
            Pokemon.DEFENSE_KEY to 50,
            Pokemon.SPEC_ATTACK_KEY to 90,
            Pokemon.SPEC_DEFENSE_KEY to 80,
            Pokemon.SPEED_KEY to 70
        ),
        listOf("Bug", "Flying")
    ),
    Pokemon(
        12, "Weedle", 3, 32, R.drawable._13,
        hashMapOf(
            Pokemon.HP_KEY to 40,
            Pokemon.ATTACK_KEY to 35,
            Pokemon.DEFENSE_KEY to 30,
            Pokemon.SPEC_ATTACK_KEY to 20,
            Pokemon.SPEC_DEFENSE_KEY to 20,
            Pokemon.SPEED_KEY to 50
        ),
        listOf("Bug", "Poison")
    ),
    Pokemon(
        13, "Kakuna", 6, 100, R.drawable._14,
        hashMapOf(
            Pokemon.HP_KEY to 45,
            Pokemon.ATTACK_KEY to 25,
            Pokemon.DEFENSE_KEY to 50,
            Pokemon.SPEC_ATTACK_KEY to 25,
            Pokemon.SPEC_DEFENSE_KEY to 25,
            Pokemon.SPEED_KEY to 35
        ),
        listOf("Bug", "Poison")
    ),
    Pokemon(
        14, "Beedrill", 10, 295, R.drawable._15,
        hashMapOf(
            Pokemon.HP_KEY to 65,
            Pokemon.ATTACK_KEY to 90,
            Pokemon.DEFENSE_KEY to 40,
            Pokemon.SPEC_ATTACK_KEY to 45,
            Pokemon.SPEC_DEFENSE_KEY to 80,
            Pokemon.SPEED_KEY to 75
        ),
        listOf("Bug", "Poison")
    ),
    Pokemon(
        15, "Pidgey", 3, 18, R.drawable._16,
        hashMapOf(
            Pokemon.HP_KEY to 40,
            Pokemon.ATTACK_KEY to 45,
            Pokemon.DEFENSE_KEY to 40,
            Pokemon.SPEC_ATTACK_KEY to 35,
            Pokemon.SPEC_DEFENSE_KEY to 35,
            Pokemon.SPEED_KEY to 56
        ),
        listOf("Normal", "Flying")
    ),
    Pokemon(
        16, "Pidgeotto", 11, 300, R.drawable._17,
        hashMapOf(
            Pokemon.HP_KEY to 63,
            Pokemon.ATTACK_KEY to 60,
            Pokemon.DEFENSE_KEY to 55,
            Pokemon.SPEC_ATTACK_KEY to 50,
            Pokemon.SPEC_DEFENSE_KEY to 50,
            Pokemon.SPEED_KEY to 71
        ),
        listOf("Normal", "Flying")
    ),
    Pokemon(
        17, "Pidgeot", 15, 395, R.drawable._18,
        hashMapOf(
            Pokemon.HP_KEY to 83,
            Pokemon.ATTACK_KEY to 80,
            Pokemon.DEFENSE_KEY to 75,
            Pokemon.SPEC_ATTACK_KEY to 70,
            Pokemon.SPEC_DEFENSE_KEY to 70,
            Pokemon.SPEED_KEY to 101
        ),
        listOf("Normal", "Flying")
    ),
    Pokemon(
        18, "Rattata", 3, 35, R.drawable._19,
        hashMapOf(
            Pokemon.HP_KEY to 56,
            Pokemon.ATTACK_KEY to 35,
            Pokemon.DEFENSE_KEY to 25,
            Pokemon.SPEC_ATTACK_KEY to 25,
            Pokemon.SPEC_DEFENSE_KEY to 35,
            Pokemon.SPEED_KEY to 72
        ),
        listOf("Normal")
    ),
    Pokemon(
        19, "Raticate", 7, 185, R.drawable._20,
        hashMapOf(
            Pokemon.HP_KEY to 55,
            Pokemon.ATTACK_KEY to 81,
            Pokemon.DEFENSE_KEY to 60,
            Pokemon.SPEC_ATTACK_KEY to 50,
            Pokemon.SPEC_DEFENSE_KEY to 70,
            Pokemon.SPEED_KEY to 97
        ),
        listOf("Normal")
    ),
).associateBy { it.id }