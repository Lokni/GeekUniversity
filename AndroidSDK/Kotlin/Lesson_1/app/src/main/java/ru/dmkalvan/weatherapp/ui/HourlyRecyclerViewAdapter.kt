package ru.dmkalvan.weatherapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.Repository
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.databinding.HourlyViewItemBinding

class HourlyRecyclerViewAdapter(private val fragment: Fragment) : RecyclerView.Adapter<HourlyRecyclerViewAdapter.ViewHolder>() {

    private val TAG = "Hourly view adapter"
    private val weather = Weather()
    private lateinit var dataSource: Repository

    fun setDataSource(dataSource: Repository) {
        this.dataSource = dataSource
    }

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
        return dataSource.size()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var _binding: HourlyViewItemBinding? = null
        private val binding get() = _binding!!

        fun setData(weather: Weather) {
            binding.hourlyTime.text = weather.sunrise.toString()
            binding.hourlyIcon.setImageResource(R.drawable.ic_launcher_background)
            binding.hourlyTemperature.text = weather.temperature.toString()
        }

    }
}