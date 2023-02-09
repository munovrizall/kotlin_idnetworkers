package com.artonov.detailgame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artonov.detailgame.R
import com.artonov.detailgame.data.Screenshot
import com.artonov.detailgame.databinding.ItemScreenshotBinding
import com.google.android.material.imageview.ShapeableImageView

class ScreenshotAdapter(private val screenshotList: ArrayList<Screenshot>): RecyclerView.Adapter<ScreenshotAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemScreenshotBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = ItemScreenshotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return screenshotList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = screenshotList[position]
        holder.binding.imgScreenshot.setImageResource(currentItem.image)
    }
}