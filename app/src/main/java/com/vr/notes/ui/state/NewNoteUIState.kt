package com.vr.notes.ui.state

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState

data class NewNoteUIState(
    val title: String = "",
    val content: String = "",
)