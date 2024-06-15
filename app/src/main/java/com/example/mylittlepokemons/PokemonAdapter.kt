package com.example.mylittlepokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.databinding.PokemonListItemBinding

class PokemonAdapter(
    private var pokemonList: List<Pokemon>, val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonVewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVewHolder {
        val viewHolder = PokemonVewHolder(
            PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: PokemonVewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = pokemonList.size

    inner class PokemonVewHolder(private var binding: PokemonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(p: Int) {
            val pokemon = pokemonList[p]
            binding.itemName.text = pokemon.name
            itemView.setOnClickListener {
                onItemClicked(p+1)
            }
        }
    }
}