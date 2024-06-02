package com.bty.unitconverter.data.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ConversionEntity::class], version = 1)
abstract class ConverterDataBase : RoomDatabase() {
    abstract val conversionDao: ConverterDAO

}