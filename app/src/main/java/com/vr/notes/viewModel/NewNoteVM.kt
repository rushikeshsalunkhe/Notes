package com.vr.notes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vr.notes.data.Note
import com.vr.notes.data.NoteRepo
import com.vr.notes.ui.state.NewNoteUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewNoteVM(
    private val noteRepo: NoteRepo
) : ViewModel() {
    private val _newNoteUiState = MutableStateFlow(NewNoteUIState())
    val newNoteUiState = _newNoteUiState.asStateFlow()

    fun setTile(title: String) {
        viewModelScope.launch {
            _newNoteUiState.update { currentState ->
                currentState.copy(
                    title = title
                )
            }
            val a = noteRepo.insertNote(
                Note(title = title, content = "")
            )
        }
    }
}