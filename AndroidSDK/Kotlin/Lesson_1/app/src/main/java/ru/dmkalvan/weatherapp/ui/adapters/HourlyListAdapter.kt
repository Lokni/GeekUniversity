package ru.dmkalvan.weatherapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.HourlyForecast

class HourlyListAdapter(private val fragment: Fragment) : RecyclerView.Adapter<HourlyListAdapter.ViewHolder>() {

    private val TAG = "Hourly view adapter"

    private var weatherData: List<HourlyForecast> = listOf()

    fun setWeather(data: List<HourlyForecast>) {
        weatherData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hourly_view_item, parent, false)
        Log.d(TAG, "onCreateViewHolder")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(weatherData[position])
        Log.d(TAG, "onBindViewHolder")
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun setData(weather: HourlyForecast) {
            itemView.findViewById<TextView>(R.id.hourly_time).text = weather.hour.toString()
            itemView.findViewById<ImageView>(R.id.hourly_icon).setImageResource(R.drawable.ic_launcher_foreground)
            itemView.findViewById<TextView>(R.id.hourly_temperature).text = weather.temperature.toString()
        }

    }
}