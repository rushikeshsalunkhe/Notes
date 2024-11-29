package com.vr.notes

import com.vr.notes.data.NoteRepo

interface AppContainer {
    val noteRepo: NoteRepo
}