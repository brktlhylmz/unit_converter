package com.bty.unitconverter.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ConverterDAO {

    @Insert
    suspend fun insertConversationInsert(entity: ConversionEntity)

    @Delete
    suspend fun deleteConversation(entity: ConversionEntity)

    @Query("DELETE FROM result_table")
    suspend fun deleteAllConversation()

    @Query("SELECT * FROM result_table")
    fun getAllConversation(): Flow<List<ConversionEntity>>

}