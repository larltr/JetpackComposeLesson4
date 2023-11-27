package com.angelika.jetpackcomposelesson4.presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelika.jetpackcomposelesson4.data.repositories.AnimeRepository
import com.angelika.jetpackcomposelesson4.models.KitsuModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _animeState = MutableStateFlow<List<KitsuModel>>(emptyList())
    val animeState = _animeState.asStateFlow()

    init {
        getAnime()
    }

    private fun getAnime(){
        viewModelScope.launch {
            animeRepository.fetchAnime().collect{
                _animeState.value = it.data
            }
        }
    }
}