package ru.dmkalvan.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.Weather

class CityListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() {

        }

    }

    interface OnItemViewClickListener {
        fun onItemViewClick(weather: Weather)
    }
}