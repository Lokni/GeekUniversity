package ru.dmkalvan.weatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.databinding.DailyViewItemBinding

class DailyListAdapter(private val fragment: Fragment) : RecyclerView.Adapter<DailyListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daily_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(weather = Weather())
    }

    override fun getItemCount(): Int {
        return 7
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var _binding: DailyViewItemBinding? = null
        private val binding get() = _binding!!

        fun setData(weather: Weather){
            binding.weekDay.text = R.string.monday.toString()
            binding.dailyWeatherIcon.setImageResource(R.drawable.ic_launcher_foreground)
            binding.dailyTemperature.text = String.format(R.string.maximum.toString(), weather.maximalTemp)
            binding.dailyNightTemperature.text = String.format(R.string.celsius.toString(), weather.minimalTemp)

        }

    }
}