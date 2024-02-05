package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weatherAppRV: RecyclerView = findViewById(R.id.rv_weather)

        weatherAppRV.layoutManager = LinearLayoutManager(this)
        weatherAppRV.setHasFixedSize(true)
        val adapter = weatherAdapter()


        val weather1 = Weather("Jan", "14", "51", "43", "Mostly Sunny", "1", "25")
        val weather2 = Weather("Jan", "15", "55", "39", "AM Showers", "1", "50")
        val weather3 = Weather("Jan", "16", "47", "39", "AM fog/PM clouds", "1", "0")
        val weather4 = Weather("Jan", "17", "53", "38", "AM Showers", "1", "11")
        val weather5 = Weather("Jan", "18", "51", "33", "Partly cloudy", "1", "22")
        val weather6 = Weather("Jan", "19", "55", "36", "Partly cloudy", "1", "90")
        val weather7 = Weather("Jan", "20", "49", "35", "Mostly cloudy", "1", "23")
        val weather8 = Weather("Jan", "21", "48", "38", "Showers", "1", "25")
        val weather9 = Weather("Jan", "21", "48", "38", "Showers", "1", "25")
        val weather10 = Weather("Jan", "21", "48", "38", "Showers", "1", "25")



        adapter.addWeather(weather1, 0)
        adapter.addWeather(weather2, 1)
        adapter.addWeather(weather3, 2)
        adapter.addWeather(weather4, 3)
        adapter.addWeather(weather5, 4)
        adapter.addWeather(weather6, 5)
        adapter.addWeather(weather7, 6)
        adapter.addWeather(weather8, 7)

        weatherAppRV.adapter = adapter

    }
}