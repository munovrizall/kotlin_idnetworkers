package com.artonov.detailgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artonov.detailgame.data.Screenshot
import com.artonov.detailgame.adapter.ScreenshotAdapter
import com.artonov.detailgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Screenshot>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvScreenshot.setHasFixedSize(true)

        list.addAll(getListScreenshot())
        showRecyclerList()
    }

    private fun getListScreenshot(): ArrayList<Screenshot> {
        val screenshot = resources.obtainTypedArray(R.array.data_screenshot)
        val listScreenshot = ArrayList<Screenshot>()

        for (i in 0..2) {
            val screenshot = Screenshot(screenshot.getResourceId(i, -1))
            listScreenshot.add(screenshot)
        }

        return listScreenshot
    }

    private fun showRecyclerList() {
        binding.rvScreenshot.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listHeroAdapter = ScreenshotAdapter(list)
        binding.rvScreenshot.adapter = listHeroAdapter
    }
}