package com.artonov.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var languageRecyclerView: RecyclerView
    private lateinit var languageArrayList: ArrayList<Language>
    lateinit var imageId: Array<Int>
    lateinit var title: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.cpp,
            R.drawable.html,
            R.drawable.kotlin,
            R.drawable.python,
            R.drawable.ruby
        )

        title = arrayOf(
            "CPP",
            "HTML",
            "Kotlin",
            "Python",
            "Ruby"
        )

        languageRecyclerView = findViewById(R.id.rvLanguage)
        languageRecyclerView.layoutManager = LinearLayoutManager(this)
        languageRecyclerView.setHasFixedSize(true)

        languageArrayList = arrayListOf()
        getLanguageData()
    }

    private fun getLanguageData() {
        for (i in imageId.indices) {
            val language = Language(imageId[i], title[i])
            languageArrayList.add(language)
        }

        languageRecyclerView.adapter = LanguageAdapter(languageArrayList)
    }

}