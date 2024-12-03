package com.vr.notes.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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
    LazyColumn {
        item {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = { true },
                placeholder = { Text("Title", fontSize = 30.sp) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
        item {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = { true },
                placeholder = { Text("Note") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.background,
                    unfocusedContainerColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    }
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