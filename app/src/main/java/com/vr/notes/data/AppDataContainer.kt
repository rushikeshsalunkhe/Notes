package com.vr.notes.data

import android.content.Context

class AppDataContainer(private val context: Context) : AppContainer {
    override val noteRepo: NoteRepo by lazy {
        OfflineNoteRepo(NotesDB.getDatabase(context).noteDao())
    }
}