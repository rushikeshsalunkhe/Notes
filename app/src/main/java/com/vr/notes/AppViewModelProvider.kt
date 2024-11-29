package com.vr.notes

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vr.notes.viewModel.HomeVM

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            HomeVM(notesApplication().container.noteRepo)
        }
    }
}

fun CreationExtras.notesApplication(): NoteApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NoteApplication)