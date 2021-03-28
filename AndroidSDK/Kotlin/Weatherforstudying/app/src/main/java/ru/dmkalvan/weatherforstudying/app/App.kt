package ru.dmkalvan.weatherforstudying.app

import android.app.Application
import androidx.room.Room
import ru.dmkalvan.weatherforstudying.room.HistoryDao
import ru.dmkalvan.weatherforstudying.room.HistoryDataBase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: App? = null
        private var db: HistoryDataBase? = null
        private const val DB_NAME = "History.db"
        private val _historyDao by lazy {
            Room.databaseBuilder(
                appInstance!!.applicationContext,
                HistoryDataBase::class.java,
                DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .historyDao()
        }

        fun getHistoryDao(): HistoryDao = _historyDao
    }
}