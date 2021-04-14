package ru.dmkalvan.contentprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dmkalvan.contentprovider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactListFragment.newInstance())
                .commitAllowingStateLoss()
        }
    }

}