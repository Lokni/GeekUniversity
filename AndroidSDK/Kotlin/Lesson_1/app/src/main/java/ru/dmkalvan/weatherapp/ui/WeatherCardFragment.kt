package ru.dmkalvan.weatherapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ru.dmkalvan.weatherapp.R
import ru.dmkalvan.weatherapp.data.DailyForecast
import ru.dmkalvan.weatherapp.data.HourlyForecast
import ru.dmkalvan.weatherapp.data.Weather
import ru.dmkalvan.weatherapp.data.getDefaultCity
import ru.dmkalvan.weatherapp.databinding.FragmentWeatherCardBinding
import ru.dmkalvan.weatherapp.ui.adapters.DailyListAdapter
import ru.dmkalvan.weatherapp.ui.adapters.HourlyListAdapter

class WeatherCardFragment : Fragment() {

    private val MY_DEFAULT_DURATION = 1000
    private var _binding: FragmentWeatherCardBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private lateinit var hourlyAdapter: HourlyListAdapter
    private lateinit var dailyAdapter: DailyListAdapter

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
                setData(appState.weatherData)
                initHourlyList(appState.hourlyWeatherData)
                initDailyList(appState.dailyWeatherData)
            }
            is AppState.Loading -> Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT)
            is AppState.Error -> {

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
    fun initHourlyList(data: List<HourlyForecast>) {
        binding.hourlyWeatherList.setHasFixedSize(true)
        val hourlyLayoutManager = LinearLayoutManager(context)
        hourlyLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.hourlyWeatherList.layoutManager = hourlyLayoutManager
        hourlyAdapter = HourlyListAdapter(this)
        binding.hourlyWeatherList.adapter = hourlyAdapter
        hourlyAdapter.setWeather(data)

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

    @SuppressLint("UseCompatLoadingForDrawables")
    fun initDailyList(data: List<DailyForecast>) {
        binding.weekDays.setHasFixedSize(true)
        val dailyLayoutManager = LinearLayoutManager(context)
        binding.weekDays.layoutManager = dailyLayoutManager
        dailyAdapter = DailyListAdapter(this)
        binding.weekDays.adapter = dailyAdapter
        dailyAdapter.setWeather(data)

        // Set separation line
        val itemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        itemDecoration.setDrawable(resources.getDrawable(R.drawable.separator, null))
        binding.weekDays.addItemDecoration(itemDecoration)

        // Set animation
        val animator = DefaultItemAnimator()
        animator.addDuration = MY_DEFAULT_DURATION.toLong()
        animator.removeDuration = MY_DEFAULT_DURATION.toLong()
        binding.weekDays.itemAnimator = animator
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return onItemSelected(item.itemId) || super.onOptionsItemSelected(item)
    }

    private fun onItemSelected(itemId: Int): Boolean {
        return when (itemId) {
            R.id.to_web -> {
                val url = String.format("https://yandex.eu/weather/%s", getDefaultCity().city)
                val webpage: Uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                startActivity(intent)
                true
            }
            R.id.to_city_list -> {

                true
            }

            else -> return false
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "weather data"


        fun newInstance(bundle: Bundle): WeatherCardFragment{
            val fragment = WeatherCardFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}