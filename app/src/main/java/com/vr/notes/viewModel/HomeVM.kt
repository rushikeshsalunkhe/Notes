package com.vr.notes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vr.notes.data.NoteRepo
import com.vr.notes.ui.state.HomeUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeVM(
    noteRepo: NoteRepo
) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> = noteRepo
        .getAllNotes()
        .map { HomeUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState()
        )
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}