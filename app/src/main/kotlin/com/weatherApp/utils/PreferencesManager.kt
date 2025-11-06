package com.weatherApp.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    companion object {
        private const val PREFS_NAME = "weather_prefs"
        private const val KEY_CITY_NAME = "key_city_name"
        private const val KEY_LATITUDE = "key_latitude"
        private const val KEY_LONGITUDE = "key_longitude"
    }

    // `SharedPreferences` en modo privado para esta aplicación.
    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    // Devuelve el nombre de la ciudad almacenada, o `null` si no existe.
    fun getCityName(): String? {
        return prefs.getString(KEY_CITY_NAME, null)
    }

    //Devuelve la latitud almacenada o `null` si no se ha guardado ninguna.
    fun getLatitude(): Float? {
        return prefs.getFloat(KEY_LATITUDE, 0.0f)
    }

    //Devuelve la longitud almacenada o `null` si no se ha guardado ninguna
    fun getLongitude(): Float? {

        return prefs.getFloat(KEY_LONGITUDE, 0.0f)
    }


    // Guarda la ubicación proporcionada. Los valores numéricos se convierten a Float
    // porque `SharedPreferences` no soporta Double directamente.
    fun saveLocation(city: String, latitude: Double, longitude: Double) {
        prefs.edit().apply {
            putString(KEY_CITY_NAME, city)
            putFloat(KEY_LATITUDE, latitude.toFloat())
            putFloat(KEY_LONGITUDE, longitude.toFloat())
            apply()
        }
    }

    /*    //TODO get sharedPreferences file

        //TODO save data in SharedPreferences
        fun saveLocation(city: String, latitude: Double, longitude: Double) {}
        //TODO implement getters for SharedPreferences values, using mock data by now
        fun getCityName(): String? = "Ávila"
        fun getLatitude(): Float? = 40.6572f
        fun getLongitude(): Float? = -4.6995f*/


}
