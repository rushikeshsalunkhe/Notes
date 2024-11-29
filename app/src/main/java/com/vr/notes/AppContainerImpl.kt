package com.vr.notes

import android.content.Context
import com.vr.notes.data.NoteRepo
import com.vr.notes.data.NotesDB
import com.vr.notes.data.OfflineNoteRepo

class AppContainerImpl(
    private val context: Context
) : AppContainer {
    override val noteRepo: NoteRepo by lazy {
        OfflineNoteRepo(
            NotesDB.Companion.getDatabase(context).noteDao()
        )
    }
}