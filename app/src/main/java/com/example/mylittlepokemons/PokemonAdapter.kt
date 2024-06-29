package com.example.mylittlepokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.databinding.PokemonListItemBinding
import com.example.mylittlepokemons.databinding.PokemonListItemSpecialBinding

class PokemonAdapter(
    val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    private var pokemonList = mapOf<Int, Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        ViewType.SPECIAL_VIEW.ordinal -> {
            val viewHolder = PokemonSpecialViewHolder(
                PokemonListItemSpecialBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            viewHolder
        }

        else -> {
            val viewHolder = PokemonStandardViewHolder(
                PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            viewHolder
        }
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(position + 1)
    }

    override fun getItemCount() = pokemonList.size

    override fun getItemViewType(position: Int) = when {
        pokemonList[position + 1]!!.isSpecial() -> ViewType.SPECIAL_VIEW.ordinal
        else -> ViewType.STANDARD_VIEW.ordinal
    }

    fun submitItems(newList: Map<Int, Pokemon>) {
        val diff = DiffUtil.calculateDiff(PokemonDiffCallback(pokemonList, newList))
        pokemonList = newList
        diff.dispatchUpdatesTo(this)
    }

    class PokemonDiffCallback(
        private val oldList: Map<Int, Pokemon>, private val newList: Map<Int, Pokemon>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition + 1]?.id == newList[newItemPosition + 1]?.id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition + 1] == newList[newItemPosition + 1]
    }

    enum class ViewType {
        STANDARD_VIEW,
        SPECIAL_VIEW,
    }

    //////////////////////// HOLDERS ///////////////////////

    abstract class PokemonViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(pokemonID: Int)
    }

    inner class PokemonStandardViewHolder(private var binding: PokemonListItemBinding) :
        PokemonViewHolder(binding) {
        override fun bind(pokemonID: Int) {
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

    inner class PokemonSpecialViewHolder(private var binding: PokemonListItemSpecialBinding) :
        PokemonViewHolder(binding) {
        override fun bind(pokemonID: Int) {
            val pokemon = pokemonList[pokemonID]
            pokemon?.let {
                binding.itemName.text = it.name
                binding.itemImage.setImageResource(it.spriteRes)
                itemView.setOnClickListener {
                    onItemClicked(pokemonID)
                }
                binding.specialImage.setImageResource(it.getSpecialImageByType())
            }
        }
    }
}