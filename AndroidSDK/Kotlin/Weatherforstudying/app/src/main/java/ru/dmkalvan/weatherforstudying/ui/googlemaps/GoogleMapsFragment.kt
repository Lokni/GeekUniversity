package ru.dmkalvan.weatherforstudying.ui.googlemaps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.dmkalvan.weatherforstudying.R

class GoogleMapsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_google_maps, container, false)
    }

    companion object {

        fun newInstance() = GoogleMapsFragment()

    }
}