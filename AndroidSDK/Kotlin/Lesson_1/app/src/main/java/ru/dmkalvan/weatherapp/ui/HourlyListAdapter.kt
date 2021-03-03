package ru.dmkalvan.weatherapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.HourlyForecast
import ru.dmkalvan.weatherapp.data.Repository
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.databinding.HourlyViewItemBinding

class HourlyListAdapter(private val fragment: Fragment) : RecyclerView.Adapter<HourlyListAdapter.ViewHolder>() {

    private val TAG = "Hourly view adapter"
    private val weather = Weather()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hourly_view_item, parent, false)
        Log.d(TAG, "onCreateViewHolder")
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(weather)
        Log.d(TAG, "onBindViewHolder")
    }

    override fun getItemCount(): Int {
        return 24
    }

    fun setWeather(data: List<HourlyForecast>) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var _binding: HourlyViewItemBinding? = null
        private val binding get() = _binding!!


        fun setData(weather: Weather) {
            binding.hourlyTime.text = weather.sunrise.toString()
            binding.hourlyIcon.setImageResource(R.drawable.ic_launcher_background)
            binding.hourlyTemperature.text = weather.temperature.toString()
        }

    }
}