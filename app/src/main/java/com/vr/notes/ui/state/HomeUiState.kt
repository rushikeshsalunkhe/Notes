package com.vr.notes.ui.state

import com.vr.notes.data.Note

data class HomeUiState(
    val noteList: List<Note> = emptyList()
)