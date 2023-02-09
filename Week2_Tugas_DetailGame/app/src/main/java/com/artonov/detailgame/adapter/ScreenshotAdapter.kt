package com.artonov.detailgame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artonov.detailgame.R
import com.google.android.material.imageview.ShapeableImageView

class ScreenshotAdapter(private val screenshotList: ArrayList<Screenshot>): RecyclerView.Adapter<ScreenshotAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val screenshot: ShapeableImageView = itemView.findViewById(R.id.imgScreenshot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_screenshot, parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return screenshotList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = screenshotList[position]
        holder.screenshot.setImageResource(currentItem.image)
    }
}