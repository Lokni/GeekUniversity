package ru.dmkalvan.weatherforstudying.ui.citylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.dmkalvan.weatherforstudying.R
import ru.dmkalvan.weatherforstudying.data.Weather
import ru.dmkalvan.weatherforstudying.databinding.FragmentCityListBinding
import ru.dmkalvan.weatherforstudying.ui.weathercard.WeatherCardFragment
import ru.dmkalvan.weatherforstudying.viewmodel.MainViewModel

class CityListFragment : Fragment() {

   private var _binding: FragmentCityListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private val adapter = CityListAdapter(object : OnItemViewClickListener {
        override fun onItemViewClick(weather: Weather) {
            val manager = activity?.supportFragmentManager
            if (manager != null){
                val bundle = Bundle()
                bundle.putParcelable(WeatherCardFragment.BUNDLE_EXTRA, weather)
            }
        }

    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    companion object {

        fun newInstance() = CityListFragment()

    }

    interface OnItemViewClickListener {
        fun onItemViewClick(weather: Weather)
    }
}