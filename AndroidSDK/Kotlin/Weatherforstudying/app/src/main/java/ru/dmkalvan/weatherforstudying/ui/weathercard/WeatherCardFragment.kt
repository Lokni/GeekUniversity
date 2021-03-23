package ru.dmkalvan.weatherforstudying.ui.weathercard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import ru.dmkalvan.weatherforstudying.R
import ru.dmkalvan.weatherforstudying.app.AppState
import ru.dmkalvan.weatherforstudying.databinding.FragmentWeatherCardBinding
import ru.dmkalvan.weatherforstudying.model.City
import ru.dmkalvan.weatherforstudying.model.Weather
import ru.dmkalvan.weatherforstudying.utils.showSnackBar
import ru.dmkalvan.weatherforstudying.viewmodel.DetailsViewModel


class WeatherCardFragment : Fragment() {



    private var _binding: FragmentWeatherCardBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherBundle: Weather
    private val viewModel: DetailsViewModel by lazy { ViewModelProvider(this).get(DetailsViewModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: Weather()
        viewModel.detailLiveData.observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getWeatherFromRemoteSource(weatherBundle.city.city)
    }

    private fun renderData(state: AppState) {
        when (state) {
            is AppState.Success -> {
                binding.mainView.visibility = View.VISIBLE
                binding.loadingLayout.visibility = View.GONE
                setWeather(state.weatherData[0])
            }
            is AppState.Loading -> {
                binding.mainView.visibility = View.GONE
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.mainView.visibility = View.VISIBLE
                binding.loadingLayout.visibility = View.GONE
                binding.mainView.showSnackBar(
                    getString(R.string.error),
                    getString(R.string.reload),
                    {
                        viewModel.getWeatherFromRemoteSource(
                            weatherBundle.city.city
                        )
                    })
            }
        }
    }

    @SuppressLint("ResourceType")
    private fun setWeather(weather: Weather) {
        with(binding) {
            val city = weatherBundle.city
            saveCity(city, weather)

            cityName.text = city.city
            weather.icon?.let {
                Picasso.get()
                    .load("https://openweathermap.org/img/wn/${it}@2x.png")
                    .into(weatherIcon)
                currentTemperature.text = String.format(getString(R.id.current_temperature), weather.temperature)
                feelsLike.text = String.format(getString(R.id.current_temperature), weather.feelsLike)
                weatherConditions.text = weather.conditions
            }

        }
    }

    private fun saveCity(
        city: City,
        weather: Weather
    ) {
        viewModel.saveCityToDB(
            Weather(
                city,
                weather.temperature,
                weather.feelsLike,
                weather.conditions
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
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