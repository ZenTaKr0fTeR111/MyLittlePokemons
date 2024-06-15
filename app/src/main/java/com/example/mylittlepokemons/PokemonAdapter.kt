package com.example.mylittlepokemons

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.databinding.PokemonListItemBinding

class PokemonAdapter(
    private var pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.PokemonVewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVewHolder {
        val viewHolder = PokemonVewHolder(
            PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            viewHolder.itemView.setOnClickListener {
                val intent = Intent(parent.context, DetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("pokemon_id", viewHolder.adapterPosition+1)
                intent.putExtras(bundle)
                parent.context.startActivity(intent)

            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: PokemonVewHolder, position: Int) {
        holder.bind(pokemonList[position])
    }

    override fun getItemCount() = pokemonList.size

    inner class PokemonVewHolder(private var binding: PokemonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.itemName.text = pokemon.name
        }
    }
}