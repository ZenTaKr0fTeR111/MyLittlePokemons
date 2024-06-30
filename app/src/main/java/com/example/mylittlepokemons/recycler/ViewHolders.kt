package com.example.mylittlepokemons.recycler

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.databinding.PokemonListItemBinding
import com.example.mylittlepokemons.databinding.PokemonListItemSpecialBinding

abstract class PokemonViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(p: Pokemon, onItemClicked: (Int) -> Unit)
}

class PokemonStandardViewHolder(private var binding: PokemonListItemBinding) :
    PokemonViewHolder(binding) {
    override fun bind(p: Pokemon, onItemClicked: (Int) -> Unit) {
        binding.itemName.text = p.name
        binding.itemImage.setImageResource(p.spriteRes)
        itemView.setOnClickListener {
            onItemClicked(p.id)
        }
    }
}

class PokemonSpecialViewHolder(private var binding: PokemonListItemSpecialBinding) :
    PokemonViewHolder(binding) {
    override fun bind(p: Pokemon, onItemClicked: (Int) -> Unit) {
        binding.itemName.text = p.name
        binding.itemImage.setImageResource(p.spriteRes)
        itemView.setOnClickListener {
            onItemClicked(p.id)
        }
        binding.specialImage.setImageResource(p.getSpecialImageByType())
    }
}