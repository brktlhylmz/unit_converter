package com.bty.unitconverter.data.repository

import com.bty.unitconverter.data.database.ConversionEntity
import com.bty.unitconverter.data.database.ConverterDAO
import kotlinx.coroutines.flow.Flow

class ConverterRepositoryImpl(
    private val converterDAO: ConverterDAO
) : ConverterRepository {
    override suspend fun addResultDatabase(entity: ConversionEntity) {
        converterDAO.insertConversationInsert(entity)
    }

    override suspend fun deleteResultDatabase(entity: ConversionEntity) {
        converterDAO.deleteConversation(entity)
    }

    override suspend fun deleteAllResultsDatabase() {
        converterDAO.deleteAllConversation()
    }

    override fun getAllResults(): Flow<List<ConversionEntity>> {
        return converterDAO.getAllConversation()
    }


}