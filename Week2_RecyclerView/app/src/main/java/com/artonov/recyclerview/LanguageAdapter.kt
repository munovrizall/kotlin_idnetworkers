package com.artonov.recyclerview

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class LanguageAdapter(private val languageList: ArrayList<Language>): RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ShapeableImageView = itemView.findViewById(R.id.imgLanguage)
        val tvTitle: TextView = itemView.findViewById(R.id.tvLanguageTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_language, parent,false)
        return LanguageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val currentItem = languageList[position]
        holder.image.setImageResource(currentItem.image)
        holder.tvTitle.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return languageList.size
    }
}