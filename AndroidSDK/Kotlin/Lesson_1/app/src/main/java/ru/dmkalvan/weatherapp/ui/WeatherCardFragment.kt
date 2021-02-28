package ru.dmkalvan.weatherapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.databinding.FragmentWeatherCardBinding

class WeatherCardFragment : Fragment() {

    private val MY_DEFAULT_DURATION = 1000
    private var _binding: FragmentWeatherCardBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var hourlyAdapter: HourlyListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentWeatherCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getWeatherFromLocalSource()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val weatherData = appState.weatherData
                binding.loadingLayout.visibility = View.GONE
                setData(weatherData)
                initHourlyList()
            }
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar
                        .make(binding.weatherCardList, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
                        .setAction(getString(R.string.reload)) { viewModel.getWeatherFromLocalSource() }
                        .show()
            }
        }

    }

    private fun setData(weatherData: Weather) {
        binding.cityName.text = weatherData.city.city
        binding.currentTemperature.text = String.format(getString(R.string.celsius), weatherData.temperature)
        binding.currentWeather.text = weatherData.weather
        binding.minimalTemperature.text = String.format(getString(R.string.minimum), weatherData.minimalTemp)
        binding.maximalTemperature.text = String.format(getString(R.string.maximum), weatherData.maximalTemp)
        binding.sunriseTime.text = String.format(getString(R.string.sunrise), weatherData.sunrise)
        binding.sunsetTime.text = String.format(getString(R.string.sunset), weatherData.sunset)
        binding.chancePrecipitation.text = String.format(getString(R.string.chance_of_precipitation), weatherData.chanceOfPrecipitation)
        binding.feelsLike.text = String.format(getString(R.string.feels_like), weatherData.feelsLike)
        binding.humidity.text = String.format(getString(R.string.humidity), weatherData.humidity)
        binding.wind.text = String.format(getString(R.string.wind), weatherData.wind)
        binding.precipitation.text = String.format(getString(R.string.precipitation), weatherData.precipitation)
        binding.pressure.text = String.format(getString(R.string.pressure), weatherData.pressure)
        binding.visibility.text = String.format(getString(R.string.visibility), weatherData.visibility)
        binding.uvIndex.text = String.format(getString(R.string.uv_index), weatherData.uvIndex)


    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun initHourlyList() {
        binding.hourlyWeatherList.setHasFixedSize(true)
        hourlyAdapter = HourlyListAdapter(this)
        binding.hourlyWeatherList.adapter

        // Set separation line
        val itemDecoration = DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL)
        itemDecoration.setDrawable(resources.getDrawable(R.drawable.separator, null))
        binding.hourlyWeatherList.addItemDecoration(itemDecoration)


        // Set animation
        val animator = DefaultItemAnimator()
        animator.addDuration = MY_DEFAULT_DURATION.toLong()
        animator.removeDuration = MY_DEFAULT_DURATION.toLong()
        binding.hourlyWeatherList.itemAnimator = animator
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = WeatherCardFragment()
    }
}