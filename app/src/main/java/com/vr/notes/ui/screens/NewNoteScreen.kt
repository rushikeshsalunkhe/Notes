package com.vr.notes.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vr.notes.ui.theme.NotesTheme

@Composable
fun NewNoteScreen(modifier: Modifier = Modifier) {
//    val noteTitleState = remember { mutableStateOf("") }
//    val noteTitle = noteTitleState.value
//
//    val noteContentState = remember { mutableStateOf("") }
//    val noteContent = noteContentState.value
//
//    val noteBackgroundState = remember { mutableStateOf("") }
//    val noteBackground = noteBackgroundState.value

    TextField(
        modifier = Modifier,
        value = "",
        onValueChange = {},
        placeholder = { Text("Title") },
    )

}

@Preview(showSystemUi = true)
@Composable
fun NewNoteScreenPreview() {
    NotesTheme {
        Scaffold {
            NewNoteScreen(modifier = Modifier.padding(it))
        }
    }
}