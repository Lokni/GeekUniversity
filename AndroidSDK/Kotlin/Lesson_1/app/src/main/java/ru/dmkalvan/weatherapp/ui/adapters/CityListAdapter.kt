package ru.dmkalvan.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.ui.CityListFragment.OnItemViewClickListener

class CityListAdapter(private var onItemViewClickListener: OnItemViewClickListener?) :
        RecyclerView.Adapter<CityListAdapter.MainViewHolder>() {
    private var weatherData: List<Weather> = listOf()

    fun setWeather(data: List<Weather>) {
        weatherData = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MainViewHolder {
        return MainViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.city_list_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(weather: Weather) {
            itemView.findViewById<TextView>(R.id.city_list).text =
                    weather.city.city
            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(weather)
            }
        }
    }
}