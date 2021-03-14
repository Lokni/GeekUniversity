package ru.dmkalvan.weatherforstudying.ui.weathercard

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
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
        with(binding) {
            mainView.visibility = View.VISIBLE
            loadingLayout.visibility = View.GONE

            val city = weatherBundle.city
            cityName.text = city.city
            weatherConditions.text = weatherDTO.fact?.conditions
            currentTemperature.text = String.format(
                getString(R.string.current_temperature),
                weatherDTO.fact?.temperature.toString()
            )
            feelsLike.text = String.format(
                getString(R.string.current_temperature),
                weatherDTO.fact?.feelsLike.toString()
            )
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: Weather()

        binding.mainView.visibility = View.GONE
        binding.loadingLayout.visibility = View.VISIBLE

        val loader = WeatherLoader(onLoadListener, weatherBundle.city.city)
        loader.loadWeather()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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