package ru.dmkalvan.weatherforstudying.ui.citylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_list_item.view.*
import ru.dmkalvan.weatherforstudying.R
import ru.dmkalvan.weatherforstudying.data.Weather
import ru.dmkalvan.weatherforstudying.ui.citylist.CityListFragment.OnItemViewClickListener

class CityListAdapter(private var onItemViewClickListener: OnItemViewClickListener?):
RecyclerView.Adapter<CityListAdapter.MainViewHolder>(){

    private var weatherData: List<Weather> = listOf()

    fun setWeather(data: List<Weather>){
        weatherData = data
        notifyDataSetChanged()
    }
    fun removeListener(){
        onItemViewClickListener = null
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CityListAdapter.MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.city_list_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: CityListAdapter.MainViewHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    inner class MainViewHolder (view: View): RecyclerView.ViewHolder(view){

        fun bind(weather: Weather){
itemView.city_list_item_text_view.text = weather.city.city
            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(weather)
            }
        }
    }
}