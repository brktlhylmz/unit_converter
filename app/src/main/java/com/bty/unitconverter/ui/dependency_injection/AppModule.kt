package com.bty.unitconverter.ui.dependency_injection

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bty.unitconverter.data.database.ConverterDataBase
import com.bty.unitconverter.data.repository.ConverterRepository
import com.bty.unitconverter.data.repository.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(@ApplicationContext context: Context): ConverterDataBase {
        return Room.databaseBuilder(
            context,
            ConverterDataBase::class.java,
            "converter_database",
        ).build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(converterDataBase: ConverterDataBase): ConverterRepository {
        return ConverterRepositoryImpl(converterDataBase.conversionDao)

    }
}