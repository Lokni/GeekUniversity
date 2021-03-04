package ru.dmkalvan.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.DailyForecast

class DailyListAdapter(private val fragment: Fragment) : RecyclerView.Adapter<DailyListAdapter.ViewHolder>() {

    private var weatherData: List<DailyForecast> = listOf()

    fun setWeather(data: List<DailyForecast>) {
        weatherData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daily_view_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(weatherData[position])
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(weather: DailyForecast) {
            itemView.findViewById<TextView>(R.id.week_day).text = weather.dayOfWeek.toString()
            itemView.findViewById<ImageView>(R.id.daily_weather_icon).setImageResource(R.drawable.ic_launcher_foreground)
            itemView.findViewById<TextView>(R.id.daily_temperature).text = weather.tempMaximum.toString()
            itemView.findViewById<TextView>(R.id.daily_night_temperature).text = weather.tempMinimum.toString()

        }

    }
}