package com.example.mylittlepokemons.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mylittlepokemons.data.Pokemon
import com.example.mylittlepokemons.databinding.PokemonListItemBinding
import com.example.mylittlepokemons.databinding.PokemonListItemSpecialBinding

class PokemonAdapter(
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<PokemonViewHolder>() {
    private var pokemonList = listOf<Pokemon>()

    enum class ViewType {
        STANDARD_VIEW,
        SPECIAL_VIEW,
    }

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
        holder.bind(pokemonList[position], onItemClicked)
    }

    override fun getItemCount() = pokemonList.size

    override fun getItemViewType(position: Int) = when {
        pokemonList[position].isSpecial() -> ViewType.SPECIAL_VIEW.ordinal
        else -> ViewType.STANDARD_VIEW.ordinal
    }

    fun submitItems(newList: List<Pokemon>) {
        val diff = DiffUtil.calculateDiff(PokemonDiffCallback(pokemonList, newList))
        pokemonList = newList
        diff.dispatchUpdatesTo(this)
    }

    class PokemonDiffCallback(
        private val oldList: List<Pokemon>, private val newList: List<Pokemon>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]
    }
}