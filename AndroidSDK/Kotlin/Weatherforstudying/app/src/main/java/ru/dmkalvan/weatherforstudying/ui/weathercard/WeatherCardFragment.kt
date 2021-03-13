package ru.dmkalvan.weatherforstudying.ui.weathercard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dmkalvan.weatherforstudying.R
import ru.dmkalvan.weatherforstudying.data.Weather
import ru.dmkalvan.weatherforstudying.data.WeatherDTO
import ru.dmkalvan.weatherforstudying.databinding.FragmentWeatherCardBinding


class WeatherCardFragment : Fragment() {

    private var _binding: FragmentWeatherCardBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherBundle: Weather
    private val onLoadListener: WeatherLoader.WeatherLoaderListener =
        object : WeatherLoader.WeatherLoaderListener {
            override fun onLoaded(weatherDTO: WeatherDTO) {
                displayWeather(weatherDTO)
            }

            override fun onFailed(throwable: Throwable) {
                throwable.localizedMessage
            }

        }

    private fun displayWeather(weatherDTO: WeatherDTO) {
        TODO("Not yet implemented")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_card, container, false)
    }

    companion object {

        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): WeatherCardFragment {
            val fragment = WeatherCardFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}