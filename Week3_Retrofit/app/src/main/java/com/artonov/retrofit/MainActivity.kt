package com.artonov.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.artonov.retrofit.api.ApiConfig
import com.artonov.retrofit.databinding.ActivityMainBinding
import com.artonov.retrofit.model.ResponseMorty
import com.artonov.retrofit.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.getService().getMorty().enqueue(object : Callback<ResponseMorty>{
            override fun onResponse(call: Call<ResponseMorty>, response: Response<ResponseMorty>) {
                if (response.isSuccessful){
                    val responseMorty = response.body()
                    val dataMorty = responseMorty?.results
                    val mortyAdapter = MortyAdapter()
                    mortyAdapter.setData(dataMorty as List<ResultsItem>)
                    binding.rvMorty.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = mortyAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseMorty>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No internet", Toast.LENGTH_LONG).show()
            }

        })
    }
}