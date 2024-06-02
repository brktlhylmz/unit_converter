package com.bty.unitconverter.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result_table")
data class ConversionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val conversionID : Int,
    @ColumnInfo("base")
    val conversionBaseType : String,
    @ColumnInfo("convert")
    val conversionConvertType : String

)