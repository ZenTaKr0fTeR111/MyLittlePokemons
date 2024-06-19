package com.example.mylittlepokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.databinding.PokemonListItemBinding

class PokemonAdapter(
    private var pokemonList: Map<Int, Pokemon>, val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonVewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVewHolder {
        val viewHolder = PokemonVewHolder(
            PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: PokemonVewHolder, position: Int) {
        holder.bind(position+1)
    }

    override fun getItemCount() = pokemonList.size

    inner class PokemonVewHolder(private var binding: PokemonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonID: Int) {
            val pokemon = pokemonList[pokemonID]
            pokemon?.let {
                binding.itemName.text = it.name
                binding.itemImage.setImageResource(it.spriteRes)
                itemView.setOnClickListener {
                    onItemClicked(pokemonID)
                }
            }
        }
    }
}