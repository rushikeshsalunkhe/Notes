package com.vr.notes.data

import kotlinx.coroutines.flow.Flow

interface NoteRepo {

    suspend fun insertNote(note: Note)

    fun getAllNotes(): Flow<List<Note>>

    fun getNoteById(id: Long): Flow<Note>

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)
}