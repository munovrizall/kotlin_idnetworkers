package com.artonov.detailgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artonov.detailgame.adapter.Screenshot
import com.artonov.detailgame.adapter.ScreenshotAdapter
import org.intellij.lang.annotations.Language

class MainActivity : AppCompatActivity() {

    private lateinit var screenshotRecyclerView: RecyclerView
    private lateinit var screenshotArrayList: ArrayList<Screenshot>
    lateinit var screenshotId: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenshotId = arrayOf(
            R.drawable.er1,
            R.drawable.er2,
            R.drawable.er3
        )
        screenshotRecyclerView = findViewById(R.id.rvScreenshot)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        screenshotRecyclerView.layoutManager = layoutManager
        screenshotRecyclerView.setHasFixedSize(true)

        screenshotArrayList = arrayListOf()
        getScreenshotData()
    }

    private fun getScreenshotData() {
        for(i in screenshotId.indices) {
            val screenshot = Screenshot(screenshotId[i])
            screenshotArrayList.add(screenshot)
        }

        screenshotRecyclerView.adapter = ScreenshotAdapter(screenshotArrayList)
    }
}