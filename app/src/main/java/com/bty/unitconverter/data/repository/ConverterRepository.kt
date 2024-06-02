package com.bty.unitconverter.data.repository

import com.bty.unitconverter.data.database.ConversionEntity
import kotlinx.coroutines.flow.Flow

interface ConverterRepository {

    suspend fun addResultDatabase(entity: ConversionEntity)

    suspend fun deleteResultDatabase(entity: ConversionEntity)

    suspend fun deleteAllResultsDatabase()

    fun getAllResults(): Flow<List<ConversionEntity>>


}