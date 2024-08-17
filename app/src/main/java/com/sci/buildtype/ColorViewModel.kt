package com.sci.buildtype

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ColorViewModel() : ViewModel() {

    private val _uiState = MutableLiveData<ColorUiState>()
    val uiState: LiveData<ColorUiState> = _uiState
    var colorUiModel: List<ColorUiModel> = emptyList()


    init {
        GlobalScope.launch {
            _uiState.postValue(ColorUiState.Loading)
            delay(2000)
            val colors = ColorRepository.getColors()
            colorUiModel = colors.map {
                ColorUiModel(
                    colorModel = it
                )
            }
            _uiState.postValue(ColorUiState.Success(colorUiModel))
        }
    }

    fun selectItem(id: String) {
        if (colorUiModel.isNotEmpty()) {
            colorUiModel = colorUiModel.map {
                if (it.colorModel.id == id) {
                    it.copy(isSelect = !it.isSelect)
                } else it
            }
            _uiState.postValue(
                ColorUiState.UpdateColorList(colorUiModel)
            )
        }
    }
}

sealed class ColorUiState {
    object Loading : ColorUiState()

    data class Success(val colors: List<ColorUiModel>) : ColorUiState()

    data class UpdateColorList(val colors: List<ColorUiModel>) : ColorUiState()
}