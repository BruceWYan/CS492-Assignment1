package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class weatherAdapter : RecyclerView.Adapter<weatherAdapter.weatherViewHolder>() {
    val weatherApp: MutableList<Weather> = mutableListOf()

    fun addWeather(weather: Weather, position: Int){
        weatherApp.add(position, weather)
        notifyItemInserted(position)
    }

    fun getLocation(location: Int) : Weather{
        return weatherApp[location]
    }

    override fun getItemCount() = weatherApp.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): weatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
        return weatherViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: weatherViewHolder, position: Int) {
        holder.bind(weatherApp[position])
    }

    class weatherViewHolder(view: View, adapter: weatherAdapter) : RecyclerView.ViewHolder(view){
        private val month: TextView = view.findViewById(R.id.weather_month)
        private val day: TextView = view.findViewById(R.id.weather_day)
        private val lo: TextView = view.findViewById(R.id.weather_lo)
        private val hi: TextView = view.findViewById(R.id.weather_hi)
        private val description: TextView = view.findViewById(R.id.weather_description)
        private val precipitation: TextView = view.findViewById(R.id.weather_precip)
        private var currentWeather: Weather? = null

        init {
            view.setOnLongClickListener{
                val location = absoluteAdapterPosition
                if (location != RecyclerView.NO_POSITION) {
                    val selected = adapter.getLocation(location)
                    val snackbar = Snackbar.make(view, selected.popDescription, Snackbar.LENGTH_INDEFINITE)
                    snackbar.setAction("X") {
                        snackbar.dismiss()
                    }
                    snackbar.show()
                }
                true
            }
        }

        fun bind(weather: Weather){
            currentWeather = weather
            description.text = weather.description
            month.text = weather.month
            day.text = weather.day
            hi.text = weather.hi + " \u2103"
            lo.text = weather.lo + " \u2103"
            precipitation.text = weather.rain + "% precipitation"
        }
    }
}