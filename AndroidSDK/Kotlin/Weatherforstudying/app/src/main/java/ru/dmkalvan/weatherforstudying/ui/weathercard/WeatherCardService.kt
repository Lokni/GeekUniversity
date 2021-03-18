package ru.dmkalvan.weatherforstudying.ui.weathercard

import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.JobIntentService
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.gson.Gson
import ru.dmkalvan.weatherforstudying.data.WeatherDTO
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection


const val CITY_NAME = "city name"
private const val REQUEST_GET = "GET"
private const val REQUEST_TIMEOUT = 10000
private const val WEATHER_API_KEY = "dc13a55c3686f4770636dd8e1857c04c"
private const val TAG = "Service Internet Connection"

class WeatherCardService : JobIntentService() {
    private val broadcastIntent = Intent(DETAILS_INTENT_FILTER)

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onHandleWork(intent: Intent) {
        val cityName = intent.getStringExtra(CITY_NAME)
        loadWeather(cityName)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadWeather(city: String?) {
        try {
            val uri =
                URL("api.openweathermap.org/data/2.5/weather?q={$city}&appid=${WEATHER_API_KEY}")
            lateinit var urlConnection: HttpsURLConnection
            try {
                urlConnection = uri.openConnection() as HttpsURLConnection
                urlConnection.requestMethod = REQUEST_GET
                urlConnection.readTimeout = REQUEST_TIMEOUT


                val bufferedReader =
                    BufferedReader(InputStreamReader(urlConnection.inputStream))

                val weatherDTO: WeatherDTO =
                    Gson().fromJson(getLines(bufferedReader), WeatherDTO::class.java)

                onResponse(weatherDTO)
            } catch (e: Exception) {
                Log.e(TAG, "Fail connection", e)
                e.printStackTrace()
            } finally {
                urlConnection.disconnect()
            }
        } catch (e: MalformedURLException) {
            Log.e(TAG, "Fail URI", e)
            e.printStackTrace()
            onMailFormedURL()
        }
    }

    private fun onMailFormedURL() {
        putLoadResult(DETAILS_URL_MALFORMED_EXTRA)
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
    }

    private fun onResponse(data: WeatherDTO) {
        val fact = data.fact
        if (fact == null) {
            onEmptyResponse()
        } else {
            onSuccessResponse(fact.temperature, fact.feelsLike, fact.conditions)
        }
    }

    private fun onEmptyResponse() {
        putLoadResult(DETAILS_RESPONSE_EMPTY_EXTRA)
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
    }

    private fun onSuccessResponse(temperature: Int?, feelsLike: Int?, conditions: String?) {
        putLoadResult(DETAILS_RESPONSE_SUCCESS_EXTRA)
        broadcastIntent.putExtra(DETAILS_TEMP_EXTRA, temperature)
        broadcastIntent.putExtra(DETAILS_FEELS_LIKE_EXTRA, feelsLike)
        broadcastIntent.putExtra(DETAILS_CONDITION_EXTRA, conditions)
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }


    private fun putLoadResult(extra: String) {
        broadcastIntent.putExtra(DETAILS_LOAD_RESULT_EXTRA, extra)
    }
}


