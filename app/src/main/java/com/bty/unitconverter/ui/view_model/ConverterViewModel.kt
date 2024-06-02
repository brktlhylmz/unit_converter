package com.bty.unitconverter.ui.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bty.unitconverter.data.database.ConversionEntity
import com.bty.unitconverter.data.model.Conversion
import com.bty.unitconverter.data.repository.ConverterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val converterRepository: ConverterRepository
) : ViewModel() {

    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)
    val inputText: MutableState<String> = mutableStateOf("")
    val typedValue: MutableState<Double> = mutableStateOf(0.0)
    val resultList: Flow<List<ConversionEntity>> = converterRepository.getAllResults()

    fun addConversionResult(baseType: String, convertType: String) {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.addResultDatabase(
                ConversionEntity(
                    conversionID = 0,
                    conversionBaseType = baseType,
                    conversionConvertType = convertType,
                )
            )
        }
    }

    fun getAllConversionsData() = listOf(
        Conversion(
            conversionID = 1,
            conversionDescription = "Pounds to Kilograms",
            conversionBaseType = "lbs",
            conversionConvertType = "kg",
            conversionMultiplyBy = 0.453592,
        ),
        Conversion(
            conversionID = 2,
            conversionDescription = "Miles to KiloMeters",
            conversionBaseType = "mi",
            conversionConvertType = "km",
            conversionMultiplyBy = 1.60934,
        ),
    )

    fun removeSelectedConversion(entity: ConversionEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteResultDatabase(entity)
        }
    }

    fun clearAllConversionHistory() {
        viewModelScope.launch(Dispatchers.IO) {
            converterRepository.deleteAllResultsDatabase()
        }
    }
}