package com.muratcay.rickandmortyjcomposeapp.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratcay.rickandmortyjcomposeapp.core.common.Resource
import com.muratcay.rickandmortyjcomposeapp.core.common.asResource
import com.muratcay.rickandmortyjcomposeapp.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadCharacters(1)
    }

    private fun loadCharacters(pageNumber: Int) {
        viewModelScope.launch {
            getCharactersUseCase.invoke(pageNumber, emptyMap()).asResource()
                .onEach { characterPage ->
                    when (characterPage) {
                        is Resource.Success -> {
                            _uiState.value =
                                uiState.value.copy(characters = characterPage.data.characters)
                        }

                        is Resource.Loading -> {
                            _uiState.value = uiState.value.copy(isLoading = true)
                        }

                        is Resource.Error -> {
                            _uiState.value = uiState.value.copy(error = characterPage.exception)
                        }
                    }
                }.launchIn(this)
        }
    }
}