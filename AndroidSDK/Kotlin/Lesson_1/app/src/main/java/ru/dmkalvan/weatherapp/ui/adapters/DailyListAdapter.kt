package ru.dmkalvan.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.DailyForecast
import ru.dmkalvan.weatherapp.databinding.DailyViewItemBinding

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
        private var _binding: DailyViewItemBinding? = null
        private val binding get() = _binding!!

        fun setData(weather: DailyForecast){
            binding.weekDay.text = weather.dayOfWeek.toString()
            binding.dailyWeatherIcon.setImageResource(R.drawable.ic_launcher_foreground)
            binding.dailyTemperature.text = String.format(R.string.maximum.toString(), weather.tempMaximum)
            binding.dailyNightTemperature.text = String.format(R.string.celsius.toString(), weather.tempMinimum)

        }

    }
}