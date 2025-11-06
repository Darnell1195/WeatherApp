package com.weatherApp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

//TODO implement class WeatherDatabase using Room

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    // fun que room implementa para darnos el dao
    abstract fun weatherDao(): WeatherDao

    companion object {
        //@volatile para que el valor del instance sea siempre el mas actualizado y visible para todos los hilos
        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun getInstance(context: android.content.Context): WeatherDatabase {
            //si ya existe la instancia la devuelve
            return INSTANCE ?: synchronized(this) {
                //si no existe la crea
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}

