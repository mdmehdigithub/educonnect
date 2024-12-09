package com.example.educonnect.presentation.viewmodel.notes

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NoteViewModel(

): ViewModel()
{
    private val _noteUIState = MutableStateFlow(NoteUIState())
    val noteUIState = _noteUIState.asStateFlow()

    fun getIndex(index: Int){
        _noteUIState.update {
            it.copy(
                subjectIndex = index
            )
        }
    }

}

data class NoteUIState(
    val subjectIndex: Int = 0
)