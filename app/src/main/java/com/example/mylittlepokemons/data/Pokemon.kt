package com.example.mylittlepokemons.data

import com.example.mylittlepokemons.R

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprite: Int,
)

val listOfPokemons = listOf<Pokemon>(
    Pokemon(1, "Bulbasaur", 7, 69, R.drawable._1),
    Pokemon(2, "Ivysaur", 10, 130, R.drawable._2),
    Pokemon(3, "Venusaur", 20, 1000, R.drawable._3),
    Pokemon(4, "Charmander", 6, 85, R.drawable._4),
    Pokemon(5, "Charmeleon", 11, 190, R.drawable._5),
    Pokemon(6, "Charizard", 17, 905, R.drawable._6),
    Pokemon(7, "Squirtle", 5, 90, R.drawable._7),
    Pokemon(8, "Wartortle", 10, 225, R.drawable._8),
    Pokemon(9, "Blastoise", 16, 855, R.drawable._9),
    Pokemon(10, "Caterpie", 3, 29, R.drawable._10),
    Pokemon(11, "Metapod", 7, 99, R.drawable._11),
    Pokemon(12, "Butterfree", 11, 320, R.drawable._12),
    Pokemon(13, "Weedle", 3, 32, R.drawable._13),
    Pokemon(14, "Kakuna", 6, 100, R.drawable._14),
    Pokemon(15, "Beedrill", 10, 295, R.drawable._15),
    Pokemon(16, "Pidgey", 3, 18, R.drawable._16),
    Pokemon(17, "Pidgeotto", 11, 300, R.drawable._17),
    Pokemon(18, "Pidgeot", 15, 395, R.drawable._18),
    Pokemon(19, "Rattata", 3, 35, R.drawable._19),
    Pokemon(20, "Raticate", 7, 185, R.drawable._20),
)