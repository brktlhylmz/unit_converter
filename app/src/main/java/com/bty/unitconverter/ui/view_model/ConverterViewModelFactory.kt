package com.bty.unitconverter.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bty.unitconverter.data.repository.ConverterRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor(
    private val converterRepository: ConverterRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConverterViewModel::class.java)){
            return ConverterViewModel(converterRepository) as T
            }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}