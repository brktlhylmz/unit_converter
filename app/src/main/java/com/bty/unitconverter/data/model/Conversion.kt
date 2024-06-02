package com.bty.unitconverter.data.model

data class Conversion(
    val conversionID : Int,
    val conversionBaseType : String,
    val conversionDescription : String,
    val conversionConvertType : String,
    val conversionMultiplyBy : Double,

)
