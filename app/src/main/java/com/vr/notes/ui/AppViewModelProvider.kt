package com.vr.notes.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vr.notes.NoteApplication
import com.vr.notes.viewModel.HomeVM

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            HomeVM(notesApp().container.noteRepo)
        }
    }
}

fun CreationExtras.notesApp(): NoteApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NoteApplication)