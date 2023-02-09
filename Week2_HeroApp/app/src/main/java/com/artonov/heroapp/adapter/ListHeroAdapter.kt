package com.artonov.heroapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artonov.heroapp.data.Hero
import com.artonov.heroapp.databinding.ItemRowHeroBinding

class ListHeroAdapter(
    private val listHero: ArrayList<Hero>
): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: ItemRowHeroBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]

        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.binding.imgItemPhoto.setImageResource(photo)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }
}